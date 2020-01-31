package com.example.simplerestapis.services;

import com.example.simplerestapis.beans.Scorecard;
import org.springframework.stereotype.Component;

@Component
public class MatchController {
    private Match match;

    public void playGame() {
        Team a = Team.createTeamInstance("IND", 1);
        Team b = Team.createTeamInstance("PAK", 2);
        Scorecard s = Scorecard.createScorecardInstance();
        match = new Match(a, b, s);
        match.createMatch();
        match.startMatch();
    }

    public Team[] showTeams() {
        return new Team[]{match.getTeamA(), match.getTeamB()};
    }

    public Scorecard finishGame() {

        return match.getS();
    }
}
