package com.example.simplerestapis.models;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
@Component
public class CricketGame {
    static  int temp = Integer.MAX_VALUE;
    public Match setup(){
        Match m = new Match();
        return m;
    }
    public int randomGenerator(){
        Random rand = new Random();
        return rand.nextInt(8);
    }
    public int start(HashMap<Integer, Integer> teamMap, Team a, Team b){
        int score = 0;
        int count = 0;
        int playerscore = 0;
        int noOfBalls = 0;
        int noOfboundaries = 0;
        int runsGiven = 0;
        List<Player> team1 = a.players;
        List<Player> team2 = b.players.subList(6,11);
        boolean finished = false;
        int overscount = 0;
        for (int i=0;i<50 && !finished;i++){
            Player Batsman = team1.get(count);
            Player Bowler = team2.get(overscount%5);
            int dotballs = 0;
            for (int j=0;j<6;j++) {
                if (teamMap.containsKey(7) && teamMap.get(7) == 10){
                    Bowler.setNumOfOvers(Bowler.getNumOfOvers() + (float)j/10);
                    finished = true;
                    break;
                }
                int temp1 = randomGenerator();
                if (temp1 == 6){
                    dotballs++;
                }
                if (temp1 != 7){
                    runsGiven+=temp1;
                    if (teamMap.containsKey(temp1)){
                        int temp2 = teamMap.get(temp1);
                        teamMap.put(temp1, temp2 + 1);
                        score+=temp1;
                    }
                    else{
                        teamMap.put(temp1,1);
                        score+=temp1;
                    }
                    playerscore+=temp1;
                    noOfBalls++;
                    if (temp1 == 4 || temp1 == 6){
                        noOfboundaries++;
                    }

                    Batsman.setNumberOfBoundaries(noOfboundaries);
                    Batsman.setNumberOfBallsPlayed(noOfBalls+1);
                }
                else {
                    Bowler.setWicketsTaken(Bowler.getWicketsTaken() + 1);
                    count++;
                    Batsman.setRunsScored(Batsman.getRunsScored() + playerscore);
                    playerscore = 0;
                    noOfBalls = 0;
                    noOfboundaries = 0;
                    if (teamMap.containsKey(temp1)) {
                        int temp2 = teamMap.get(temp1);
                        teamMap.put(temp1, temp2 + 1);
                    } else {
                        teamMap.put(temp1, 1);
                    }
                }
                if(score>temp) {
                    Bowler.setNumOfOvers(Bowler.getNumOfOvers() + (float)j/10);
                    finished = true;
                    break;
                }
            }
            if (dotballs == 6){
                Bowler.setMaidenOvers(Bowler.getMaidenOvers() + 1 );
            }
            Bowler.setRunsGiven(Bowler.getRunsGiven() + runsGiven);
            Bowler.setNumOfOvers(Bowler.getNumOfOvers() + 1);
            overscount++;
            runsGiven = 0;
        }
        System.out.println(Arrays.asList(teamMap));
        temp = score;
        return score;
    }


}