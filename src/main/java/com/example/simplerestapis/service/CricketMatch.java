package com.example.simplerestapis.service;

import com.example.simplerestapis.repository.Playerrepository;
import com.example.simplerestapis.repository.Teamrepository;
import com.example.simplerestapis.service.scorecard.bean.Scorecard;
import com.example.simplerestapis.service.team.bean.Team;
import com.example.simplerestapis.service.team.util.TeamUtils;

import com.example.simplerestapis.service.scorecard.util.ScoreCardUtil;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class CricketMatch {
    private Team teamA;
    private Team teamB;
    private Scorecard scorecard;

    public CricketMatch(){
        this.teamA = Team.createTeamInstance("IND",1);
        this.teamB = Team.createTeamInstance("PAK",2);
        this.scorecard = Scorecard.createScorecardInstance();
    }

    public void createMatch(Teamrepository teamrepository, Playerrepository playerrepository){
         TeamUtils.createTeam(teamA,teamrepository,playerrepository);
         TeamUtils.createTeam(teamB,teamrepository,playerrepository);
         ScoreCardUtil.initialize(this.teamA, this.teamB, this.scorecard);
    }

    public void startMatch() {
        int target = Integer.MAX_VALUE;
        int teamAScore = Playinning.startGame(this.teamA,this.teamB,target,this.scorecard, "A");
        int teamBScore = Playinning.startGame(this.teamB,this.teamA,teamAScore,this.scorecard,"B");
        ScoreCardUtil.updateScorecard(teamA , teamB , scorecard, teamAScore,teamBScore);
    }
}
