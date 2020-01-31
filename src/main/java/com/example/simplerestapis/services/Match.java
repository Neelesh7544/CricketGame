package com.example.simplerestapis.services;

import com.example.simplerestapis.beans.Scorecard;
import com.example.simplerestapis.util.CreateTeamUtil;

import com.example.simplerestapis.util.ScoreCardUtil;
import com.example.simplerestapis.util.TeamscorecardUtil;
import lombok.Data;

@Data
public class Match {
    private Team teamA;
    private Team teamB;
    private Scorecard s;

    public Match(Team a , Team b, Scorecard s){
        this.teamA = a;
        this.teamB = b;
        this.s = s;
    }
    public void createMatch(){
         CreateTeamUtil.createTeam(this.teamA);
         CreateTeamUtil.createTeam(this.teamB);
         ScoreCardUtil.initialize(this.teamA, this.teamB, this.s);
    }
    public void startMatch() {
        int target = Integer.MAX_VALUE;
        int teamAScore = teamA.playInning(this.teamA, this.teamB, target,this.s);
        int teamBScore = teamB.playInning(this.teamB, this.teamA, teamAScore,this.s);
        TeamscorecardUtil.updateTeamScoreCard(teamA, s);
        TeamscorecardUtil.updateTeamScoreCard(teamB, s);
        if (teamAScore > teamBScore){
            s.setWinner(teamA.getName());
            s.setResult(teamA.getName() + " won the match by " + (teamAScore - teamBScore) + "runs.");
        }
        else if (teamAScore < teamBScore){
            s.setWinner(teamB.getName());
            if (teamB.getTeamScoreMap().containsKey(7))
            s.setResult(teamB.getName() + " won the match by " + (10 - teamB.getTeamScoreMap().get(7)) + "wickets.");
        }
        else{
            s.setWinner("Match Tied");
        }
    }
}
