package com.example.simplerestapis.service;

import com.example.simplerestapis.service.scorecard.Scorecard;
import org.springframework.stereotype.Component;

@Component
public class MatchController {

    public Scorecard playGame() {
        CricketMatch cricketMatch = new CricketMatch();
        cricketMatch.createMatch();
        cricketMatch.startMatch();
        return cricketMatch.getScorecard();
    }
}
