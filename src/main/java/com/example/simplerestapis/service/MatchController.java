package com.example.simplerestapis.service;

import com.example.simplerestapis.repository.Playerrepository;
import com.example.simplerestapis.repository.Scorecardrepository;
import com.example.simplerestapis.repository.Teamrepository;
import com.example.simplerestapis.service.scorecard.bean.Scorecard;
import org.springframework.stereotype.Service;


@Service
public class MatchController {
    public Scorecard playGame(Scorecardrepository scorecardrepository, Teamrepository teamrepository, Playerrepository playerrepository) {
        CricketMatch cricketMatch = new CricketMatch();
        cricketMatch.createMatch(teamrepository,playerrepository);
        cricketMatch.startMatch();
        Scorecard scorecard = cricketMatch.getScorecard();
        scorecardrepository.save(scorecard);
        return scorecard;
    }
}
