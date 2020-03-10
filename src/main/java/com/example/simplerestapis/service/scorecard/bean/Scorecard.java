package com.example.simplerestapis.service.scorecard.bean;

import com.example.simplerestapis.service.team.bean.Teamscorecard;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.HashMap;


@Data
public class Scorecard {
    @Id
    private String id;
    private String winner;
    private String result;
    private Date createdDate = new Date();
    private HashMap<Integer, Teamscorecard> teamScores;
    public static Scorecard createScorecardInstance(){
        Scorecard s = new Scorecard();
        return s;
    }

}
