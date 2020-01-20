package com.example.simplerestapis.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CricketGame {
    private String winner;
    private long teamAscore;
    private long teamBscore;
    private String result;
    private HashMap<Integer, Integer> teamA = new HashMap<>();
    private HashMap<Integer, Integer> teamB = new HashMap<>();
    public int randomGenerator(){
        Random rand = new Random();
        return rand.nextInt(8);
    }
    public void start(){
        for (int i=0;i<300;i++){
            if (teamA.containsKey(7) && teamA.get(7) == 10){
                break;
            }
            int temp1 = randomGenerator();
            if (temp1 != 7){
                if (teamA.containsKey(temp1)){
                    int temp2 = teamA.get(temp1);
                    teamA.put(temp1, temp2 + 1);
                    teamAscore += temp1;
                }
                else{
                    teamA.put(temp1,1);
                    teamAscore += temp1;
                }
            }
            else{
                if (teamA.containsKey(temp1)){
                    int temp2 = teamA.get(temp1);
                    teamA.put(temp1, temp2 + 1);
                }
                else{
                    teamA.put(temp1,1);
                }
            }
        }
        System.out.println(teamAscore);
        for (int i=0;i<300;i++){
            if (teamB.containsKey(7) && teamB.get(7) == 10) {
                break;
            }
            if (teamBscore> teamAscore){
                break;
            }
            int temp1 = randomGenerator();
            if (temp1 != 7){
                if (teamB.containsKey(temp1)){
                    int temp2 = teamB.get(temp1);
                    teamB.put(temp1, temp2 + 1);
                    teamBscore += temp1;
                }
                else{
                    teamB.put(temp1,1);
                    teamBscore += temp1;
                }
            }
            else{
                if (teamB.containsKey(temp1)){
                    int temp2 = teamB.get(temp1);
                    teamB.put(temp1, temp2 + 1);
                }
                else{
                    teamB.put(temp1,1);
                }
            }
        }
        System.out.println(Arrays.asList(teamA));
        System.out.println(Arrays.asList(teamB));
    }
    public void Result(){
        if (teamAscore > teamBscore){
            setWinner("Team A");
            setResult("Team A won by " + (teamAscore - teamBscore) + " runs");
        }
        else if (teamAscore < teamBscore){
            setWinner("Team B");
            setResult("Team B won by " + (10 - teamB.get(7)) + " Wickets");
        }
        else{
            setWinner("Match Tied");
        }
    }
    public String getWinner() {
        return winner;
    }
    public String getResult(){
        return result;
    }
    public void setResult(String r){
        this.result = r;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public long getteamAscore() {
        return teamAscore;
    }
    public void setteamAscore(long score) {
        this.teamAscore = score;
    }
    public long getteamBscore() {
        return teamBscore;
    }
    public void setteamBscore(long score) {
        this.teamBscore = score;
    }
}