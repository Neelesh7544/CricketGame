package com.example.simplerestapis.models;

import java.util.HashMap;

public class Match {
    Team A;
    Team B;
    int teamAscore;
    int teamBscore;
    Result r = new Result();
    Match(){
        A = new Team();
        B = new Team();
    }
    public void startMatch(){
        teamAscore = A.playInning();
        teamBscore = B.playInning();
    }
    public Result displayResult(HashMap<Integer,Integer> teamAMap , HashMap<Integer,Integer> teamBMap){
        System.out.println(teamAscore);
        System.out.println(teamBscore);
        r.setteamAscore(teamAscore);
        r.setteamBscore(teamBscore);
        if (teamAscore > teamBscore){
            r.setWinner("Team A");
            r.setResult("Team A won by " + (r.getteamAscore() - r.getteamBscore()) + " runs");
        }
        else if (teamAscore < teamBscore){
            r.setWinner("Team B");
            r.setResult("Team B won by " + (10 - teamBMap.get(7)) + " Wickets");
        }
        else{
            r.setWinner("Match Tied");
        }

        return r;
    }
}
