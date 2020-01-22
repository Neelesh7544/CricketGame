package com.example.simplerestapis.models;

import org.springframework.stereotype.Component;

@Component
public class MatchController {
    CricketGame game = new CricketGame();
    Match m;
    Player p ;
    public void playGame(){
        m = game.setup();
        m.startMatch();

    }

    public Result finishGame() {

        return m.displayResult(m.A.teamMap,m.B.teamMap);
    }
    public Team[] generateScoreCard(){
        return new Team[]{m.A,m.B};
    }

    public Team[] showTeams() {
        return new Team[]{m.A,m.B};
    }
}
