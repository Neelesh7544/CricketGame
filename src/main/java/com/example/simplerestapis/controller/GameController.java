package com.example.simplerestapis.controller;
import com.example.simplerestapis.models.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    MatchController m = new MatchController();
    @RequestMapping("/match")
    public Result Match() {
        m.playGame();
        Result r = m.finishGame();
        return r;
    }
    @RequestMapping("/teams")
    public Team[] teams(){

        return m.showTeams();
    }
    @RequestMapping("/scorecard")
    public Team[] scoreCard(){

        return m.generateScoreCard();
    }
}