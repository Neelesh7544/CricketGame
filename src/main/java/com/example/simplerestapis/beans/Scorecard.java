package com.example.simplerestapis.beans;

import lombok.Data;
import java.util.TreeMap;

@Data
public class Scorecard {

    private String winner;
    private String result;
    private TreeMap<Integer,Teamscorecard> teamScores = new TreeMap<>();

    public static Scorecard createScorecardInstance(){
        Scorecard s = new Scorecard();
        return s;
    }
}
