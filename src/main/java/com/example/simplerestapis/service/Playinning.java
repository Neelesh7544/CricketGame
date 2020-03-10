package com.example.simplerestapis.service;

import com.example.simplerestapis.service.player.beans.Player;
import com.example.simplerestapis.service.player.beans.Playerscorecard;
import com.example.simplerestapis.service.scorecard.bean.Scorecard;
import com.example.simplerestapis.service.player.util.PlayerUtils;
import com.example.simplerestapis.service.player.util.PlayerscorecardUtil;
import com.example.simplerestapis.service.team.bean.Team;
import com.example.simplerestapis.service.team.bean.Teamscorecard;
import com.example.simplerestapis.service.team.util.TeamscorecardUtil;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Playinning {

    public static int randomGenerator(double[] distribution) {
        int[] numsToGenerate = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        //Enumerated Integer Distribution class is implemented in https://commons.apache.org/proper/commons-math/javadocs/api-3.6/org/apache/commons/math3/distribution/EnumeratedIntegerDistribution.html
        EnumeratedIntegerDistribution dist = new EnumeratedIntegerDistribution(numsToGenerate, distribution);
        return dist.sample();
    }

    public static int startGame(Team teamA, Team teamB, int temp, Scorecard s, String playfirst) {
        int teamScore = 0;
        boolean finished = false;
        int batsmanCount = 0;
        int bowlerCount = 0;
        Team battingTeam = teamA;
        Team bowlingTeam = teamB;
        List<Player> team1 = battingTeam.getPlayers();
        List<Player> team2 = bowlingTeam.getPlayers().subList(6, 11);
        Teamscorecard battingteamscorecard = s.getTeamScores().get(battingTeam.getId());
        Teamscorecard bowlingteamscorecard = s.getTeamScores().get(bowlingTeam.getId());
        for (int i = 0; i < 50 && !finished; i++) {
            Player bowler = team2.get(bowlerCount % 5);
            Playerscorecard bowlerScorecard = bowlingteamscorecard.getPlayerScores().get(bowler.getId());
            int dotballs = 0;
            for (int j = 0; j < 6; j++) {
                Player batsman = team1.get(batsmanCount);
                Playerscorecard batsmanScorecard = null;
                HashMap<String, Playerscorecard> m = battingteamscorecard.getPlayerScores();
                if (m.containsKey(batsman.getId())) {
                    batsmanScorecard = m.get(batsman.getId());
                }
                if (battingteamscorecard.getNoOfWickets() == 10) {
                    PlayerscorecardUtil.incrementOvers(bowlerScorecard, (float) j / 10);
                    finished = true;
                    break;
                }
                int rating = batsman.getRating();
                double[] distribution = PlayerUtils.getdistribution(rating);
                int rand = randomGenerator(distribution);
                if (rand == 0) {
                    dotballs++;
                }
                if (rand != 7) {
                    teamScore += rand;
                    if (rand == 4) {
                        PlayerscorecardUtil.incrementBoundaries(batsmanScorecard);
                        TeamscorecardUtil.incrementFours(battingteamscorecard);
                    }
                    if (rand == 6) {
                        PlayerscorecardUtil.incrementBoundaries(batsmanScorecard);
                        TeamscorecardUtil.incrementSixes(battingteamscorecard);
                    }
                    PlayerscorecardUtil.incrementRunsScored(batsmanScorecard, rand);
                    PlayerscorecardUtil.incrementRunsGiven(bowlerScorecard, rand);
                } else {
                    TeamscorecardUtil.incrementWickets(battingteamscorecard);
                    PlayerscorecardUtil.incrementWicktesTaken(bowlerScorecard);
                    batsmanCount++;
                }
                PlayerscorecardUtil.incrementNoOfBallsPlayed(batsmanScorecard);
                if (teamScore > temp) {
                    PlayerscorecardUtil.incrementOvers(bowlerScorecard, (float) j / 10);

                    finished = true;
                    break;
                }
            }

            if (finished == true) {
                break;
            }
            if (dotballs == 6) {
                PlayerscorecardUtil.incrementMaidenOvers(bowlerScorecard);
            }
            PlayerscorecardUtil.incrementOvers(bowlerScorecard, 1);
            bowlerCount++;
        }
        battingteamscorecard.setTeamScore(teamScore);
        temp = teamScore;
        return teamScore;
    }
}