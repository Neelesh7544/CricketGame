package com.example.simplerestapis.util;

import com.example.simplerestapis.beans.Player;
import com.example.simplerestapis.beans.Playerscorecard;
import com.example.simplerestapis.beans.Scorecard;
import com.example.simplerestapis.beans.Teamscorecard;
import com.example.simplerestapis.services.Team;

import java.util.HashMap;
import java.util.TreeMap;

public class ScoreCardUtil {
    public static void initialize(Team teamA, Team teamB, Scorecard s){

        Teamscorecard teamAScoreCard = new Teamscorecard();
        Teamscorecard teamBScoreCard = new Teamscorecard();
        TreeMap<Integer,Playerscorecard> teamAScoreMap = new TreeMap<>();
        for (int i = 0;i<11;i++){
            Playerscorecard p = new Playerscorecard();
            teamAScoreMap.put(teamA.getPlayers().get(i).getId(), p);
        }
        teamAScoreCard.setPlayerScores(teamAScoreMap);
        TreeMap<Integer,Playerscorecard> teamBScoreMap = new TreeMap<>();
        for(int i = 0;i<11;i++){
            Playerscorecard p = new Playerscorecard();
            teamBScoreMap.put(teamB.getPlayers().get(i).getId(), p);
        }
        teamBScoreCard.setPlayerScores(teamBScoreMap);
        TreeMap<Integer,Teamscorecard> teamScores = new TreeMap<>();
        teamScores.put(teamA.getId(), teamAScoreCard);
        teamScores.put(teamB.getId(), teamBScoreCard);
        s.setTeamScores(teamScores);
    }
}
