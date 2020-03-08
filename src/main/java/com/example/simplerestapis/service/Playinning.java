package com.example.simplerestapis.service;

import com.example.simplerestapis.service.player.beans.Player;
import com.example.simplerestapis.service.scorecard.Playerscorecard;
import com.example.simplerestapis.service.scorecard.Scorecard;
import com.example.simplerestapis.service.player.util.PlayerUtils;
import com.example.simplerestapis.service.scorecard.PlayerscorecardUtil;
import com.example.simplerestapis.service.team.Team;
import com.example.simplerestapis.service.team.Teamscorecard;
import com.example.simplerestapis.service.team.TeamscorecardUtil;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;

import java.util.List;
import java.util.HashMap;

public class Playinning {

    public static int randomGenerator(double[] distribution) {
        int[] numsToGenerate = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        //Enumerated Integer Distribution class is implemented in https://commons.apache.org/proper/commons-math/javadocs/api-3.6/org/apache/commons/math3/distribution/EnumeratedIntegerDistribution.html
        EnumeratedIntegerDistribution dist = new EnumeratedIntegerDistribution(numsToGenerate, distribution);
        return dist.sample();
    }

    public static int startGame(int temp, Scorecard s, String playfirst) {
        int teamScore = 0;
        boolean finished = false;
        int batsmanCount = 0;
        int bowlerCount = 0;
        if (playfirst == "A") {
            Team battingTeam = (Team) s.getTeamScores().keySet().toArray()[1];
            Team bowlingTeam = (Team) s.getTeamScores().keySet().toArray()[0];
            List<Player> team1 = battingTeam.getPlayers();
            List<Player> team2 = bowlingTeam.getPlayers().subList(6, 11);
            Teamscorecard battingteamscorecard = s.getTeamScores().get(battingTeam);
            Teamscorecard bowlingteamscorecard = s.getTeamScores().get(bowlingTeam);
            for (int i = 0; i < 50 && !finished; i++) {
                Player bowler = team2.get(bowlerCount % 5);
                Playerscorecard bowlerScorecard = bowlingteamscorecard.getPlayerScores().get(bowler);
                int dotballs = 0;
                for (int j = 0; j < 6; j++) {
                    Player batsman = team1.get(batsmanCount);
                    Playerscorecard batsmanScorecard = null;
                    HashMap<Player, Playerscorecard> m = battingteamscorecard.getPlayerScores();
                    if (m.containsKey(batsman)) {
                        batsmanScorecard = m.get(batsman);
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
        } else if (playfirst == "B") {
            Team battingTeam = (Team) s.getTeamScores().keySet().toArray()[0];
            Team bowlingTeam = (Team) s.getTeamScores().keySet().toArray()[1];
            List<Player> team1 = battingTeam.getPlayers();
            List<Player> team2 = bowlingTeam.getPlayers().subList(6, 11);
            Teamscorecard battingteamscorecard = s.getTeamScores().get(battingTeam);
            Teamscorecard bowlingteamscorecard = s.getTeamScores().get(bowlingTeam);
            for (int i = 0; i < 50 && !finished; i++) {
                Player bowler = team2.get(bowlerCount % 5);
                Playerscorecard bowlerScorecard = bowlingteamscorecard.getPlayerScores().get(bowler);
                int dotballs = 0;
                for (int j = 0; j < 6; j++) {
                    Player batsman = team1.get(batsmanCount);
                    Playerscorecard batsmanScorecard = null;
                    HashMap<Player, Playerscorecard> m = battingteamscorecard.getPlayerScores();
                    if (m.containsKey(batsman)) {
                        batsmanScorecard = m.get(batsman);
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
        }
        return teamScore;
    }
}