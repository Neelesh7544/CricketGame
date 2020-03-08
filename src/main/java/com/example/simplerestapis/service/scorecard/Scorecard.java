package com.example.simplerestapis.service.scorecard;

import com.example.simplerestapis.service.team.Team;
import com.example.simplerestapis.service.team.Teamscorecard;
import lombok.Data;

import java.util.HashMap;

@Data
public class Scorecard {

    private String winner;
    private String result;
    private HashMap<Team, Teamscorecard> teamScores;
    public static Scorecard createScorecardInstance(){
        Scorecard s = new Scorecard();
        return s;
    }
}
