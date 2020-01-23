package com.example.simplerestapis.models;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

@Component
public class CricketGame {
    public Match setup() {
        Match m = new Match();
        return m;
    }

    public int randomGenerator() {
        Random rand = new Random();
        return rand.nextInt(8);
    }

    public int start(HashMap<Integer, Integer> teamMap, Team a, Team b, int temp) {
        List<Player> team1 = a.players;
        List<Player> team2 = b.players.subList(6, 11);
        boolean finished = false;
        int batsmanCount = 0;
        int bolwerCount = 0;
        int teamScore = 0;
        for (int i = 0; i < 50 && !finished; i++) {
            Player Bowler = team2.get(bolwerCount % 5);
            int dotballs = 0;
            for (int j = 0; j < 6; j++) {
                Player Batsman = team1.get(batsmanCount);
                if (teamMap.containsKey(7) && teamMap.get(7) == 10) {
                    Bowler.setNumOfOvers(Bowler.getNumOfOvers() + (float) j / 10);
                    finished = true;
                    break;
                }
                int rand = randomGenerator();
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
                        Batsman.setNumberOfBoundaries(Batsman.getNumberOfBoundaries() + 1);
                    }
                    Batsman.setRunsScored(Batsman.getRunsScored() + rand);
                    Bowler.setRunsGiven(Bowler.getRunsGiven() + rand);
                } else {
                    Bowler.setWicketsTaken(Bowler.getWicketsTaken() + 1);
                    batsmanCount++;
                    if (teamMap.containsKey(rand)) {
                        teamMap.put(rand, teamMap.get(rand) + 1);
                    } else {
                        teamMap.put(rand, 1);
                    }
                }
                Batsman.setNumberOfBallsPlayed(Batsman.getNumberOfBallsPlayed() + 1);
                if (teamScore > temp) {
                    Bowler.setNumOfOvers(Bowler.getNumOfOvers() + (float) j / 10);
                    finished = true;
                    break;
                }
            }

            if (finished == true) {
                break;
            }
            if (dotballs == 6) {
                Bowler.setMaidenOvers(Bowler.getMaidenOvers() + 1);
            }
            Bowler.setNumOfOvers(Bowler.getNumOfOvers() + 1);
            bolwerCount++;
        }
        temp = teamScore;
        return teamScore;
    }


}