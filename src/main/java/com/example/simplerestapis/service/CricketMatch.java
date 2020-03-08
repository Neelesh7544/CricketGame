package com.example.simplerestapis.service;

import com.example.simplerestapis.service.scorecard.Scorecard;
import com.example.simplerestapis.service.team.Team;
import com.example.simplerestapis.service.team.TeamUtils;

import com.example.simplerestapis.service.scorecard.ScoreCardUtil;
import lombok.Data;

@Data
public class CricketMatch {
    private Team teamA;
    private Team teamB;
    private Scorecard scorecard;

    public CricketMatch(){
        this.teamA = Team.createTeamInstance("IND", 1);
        this.teamB = Team.createTeamInstance("PAK", 2);
        this.scorecard = Scorecard.createScorecardInstance();
    }

    public void createMatch(){
         TeamUtils.createTeam(this.teamA);
         TeamUtils.createTeam(this.teamB);
         ScoreCardUtil.initialize(this.teamA, this.teamB, this.scorecard);
    }

    public void startMatch() {
        int target = Integer.MAX_VALUE;
        int teamAScore = Playinning.startGame(target,this.scorecard, "A");
        int teamBScore = Playinning.startGame(teamAScore,this.scorecard,"B");
        ScoreCardUtil.updateScorecard(teamA , teamB , scorecard, teamAScore,teamBScore);
    }
}
