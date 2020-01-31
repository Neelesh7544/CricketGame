package com.example.simplerestapis.services;

import com.example.simplerestapis.beans.Player;
import com.example.simplerestapis.beans.Playerscorecard;
import com.example.simplerestapis.beans.Scorecard;
import com.example.simplerestapis.util.PlayerRatingUtil;
import com.example.simplerestapis.util.PlayerscorecardUtil;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;

import java.util.List;
import java.util.HashMap;

public class CricketGame {

    public int randomGenerator(double[] distribution) {
        int[] numsToGenerate = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        //Enumerated Integer Distribution class is implemented in https://commons.apache.org/proper/commons-math/javadocs/api-3.6/org/apache/commons/math3/distribution/EnumeratedIntegerDistribution.html
        EnumeratedIntegerDistribution dist = new EnumeratedIntegerDistribution(numsToGenerate, distribution);
        return dist.sample();
    }

    public int start(HashMap<Integer, Integer> teamMap, Team a, Team b, int temp, Scorecard s) {
        List<Player> team1 = a.getPlayers();
        List<Player> team2 = b.getPlayers().subList(6, 11);
        boolean finished = false;
        int batsmanCount = 0;
        int bowlerCount = 0;
        int teamScore = 0;
        for (int i = 0; i < 50 && !finished; i++) {
            Player bowler = team2.get(bowlerCount % 5);
            Playerscorecard bowlerScorecard = s.getTeamScores().get(b.getId()).getPlayerScores().get(bowler.getId());
            int dotballs = 0;
            for (int j = 0; j < 6; j++) {
                Player batsman = team1.get(batsmanCount);
                Playerscorecard batsmanScorecard = s.getTeamScores().get(a.getId()).getPlayerScores().get(batsman.getId());
                if (teamMap.containsKey(7) && teamMap.get(7) == 10) {
                    PlayerscorecardUtil.incrementOvers(bowlerScorecard, (float) j /10);
                    finished = true;
                    break;
                }
                int rating = batsman.getRating();
                double[] distribution = PlayerRatingUtil.getdistribution(rating);
                int rand = randomGenerator(distribution);
                if (rand == 0) {
                    dotballs++;
                }
                if (rand != 7) {
                    if (teamMap.containsKey(rand)) {
                        teamMap.put(rand, teamMap.get(rand) + 1);
                    } else {
                        teamMap.put(rand, 1);
                    }
                    teamScore += rand;
                    if (rand == 4 || rand == 6) {
                        PlayerscorecardUtil.incrementBoundaries(batsmanScorecard);
                    }
                    PlayerscorecardUtil.incrementRunsScored(batsmanScorecard, rand);
                    PlayerscorecardUtil.incrementRunsGiven(bowlerScorecard, rand);
                } else {
                    PlayerscorecardUtil.incrementWicktesTaken(bowlerScorecard);
                    batsmanCount++;
                    if (teamMap.containsKey(rand)) {
                        teamMap.put(rand, teamMap.get(rand) + 1);
                    } else {
                        teamMap.put(rand, 1);
                    }
                }
                PlayerscorecardUtil.incrementNoOfBallsPlayed(batsmanScorecard);
                if (teamScore > temp) {
                    PlayerscorecardUtil.incrementOvers(bowlerScorecard , (float) j /10);
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
            PlayerscorecardUtil.incrementOvers(bowlerScorecard,1);
            bowlerCount++;
        }
        temp = teamScore;
        return teamScore;
    }


}