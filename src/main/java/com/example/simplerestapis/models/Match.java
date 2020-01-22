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
        A.setName("IND");
        for (int i=0;i<11;i++){
            Player p = new Player();
            p.setName("ABC");
            A.addPlayer(p);
        }
        B = new Team();
        B.setName("AUS");
        for (int i=0;i<11;i++){
            Player p = new Player();
            p.setName("DEF");
            B.addPlayer(p);
        }
    }
    public void startMatch(){
        teamAscore = A.playInning(A,B);
        teamBscore = B.playInning(B,A);
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
            r.setResult("Both Teams Played Well");
        }

        return r;
    }
}
