package com.example.simplerestapis.service.scorecard;
import com.example.simplerestapis.service.player.beans.Player;
import com.example.simplerestapis.service.team.Teamscorecard;
import com.example.simplerestapis.service.team.Team;

import java.util.HashMap;


public class ScoreCardUtil {
    public static void initialize(Team teamA, Team teamB, Scorecard s){
        HashMap<Team,Teamscorecard> teamScores = new HashMap<>();
        HashMap<Player,Playerscorecard> teamAScoreMap = new HashMap<>();
        for (int i = 0;i<11;i++){
            Playerscorecard p = new Playerscorecard();
            teamAScoreMap.put(teamA.getPlayers().get(i), p);
        }
        Teamscorecard teamAScoreCard = new Teamscorecard();
        teamAScoreCard.setPlayerScores(teamAScoreMap);
        HashMap<Player,Playerscorecard> teamBScoreMap = new HashMap<>();
        for(int i = 0;i<11;i++){
            Playerscorecard p = new Playerscorecard();
            teamBScoreMap.put(teamB.getPlayers().get(i), p);
        }
        Teamscorecard teamBScoreCard = new Teamscorecard();
        teamBScoreCard.setPlayerScores(teamBScoreMap);
        teamScores.put(teamA, teamAScoreCard);
        teamScores.put(teamB, teamBScoreCard);
        s.setTeamScores(teamScores);
    }
    public static void updateScorecard(Team teamA, Team teamB, Scorecard s, int teamAScore, int teamBScore){
        if (teamAScore > teamBScore){
            s.setWinner(teamA.getName());
            s.setResult(teamA.getName() + " won the match by " + (teamAScore - teamBScore) + "runs.");
        }
        else if (teamAScore < teamBScore){
            s.setWinner(teamB.getName());
            s.setResult(teamB.getName() + " won the match by " + (10 - s.getTeamScores().get(teamB).getNoOfWickets()) + "wickets.");
        }
        else{
            s.setWinner("Match Tied");
        }
    }
}
