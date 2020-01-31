package com.example.simplerestapis.util;

import com.example.simplerestapis.beans.Scorecard;
import com.example.simplerestapis.services.Team;

import java.util.HashMap;

public class TeamscorecardUtil {
    public static void updateTeamScoreCard(Team team, Scorecard s){
        int teamScore = 0;
        int noOfBalls = 0;
        int noOfWikcets = 0;
        int noOfFours = 0;
        int noOfSixes = 0;
        for (HashMap.Entry<Integer, Integer> item : team.getTeamScoreMap().entrySet()) {
            int key = item.getKey();
            int value = item.getValue();
            if (key !=7) {
                teamScore += key * value;
            }
            noOfBalls += value;
        }
        if (team.getTeamScoreMap().containsKey(7)){
            noOfWikcets = team.getTeamScoreMap().get(7);
        }
        if (team.getTeamScoreMap().containsKey(4)){
            noOfFours = team.getTeamScoreMap().get(4);
        }
        if (team.getTeamScoreMap().containsKey(6)){
            noOfSixes = team.getTeamScoreMap().get(6);
        }
        s.getTeamScores().get(team.getId()).setTeamScore(teamScore);
        s.getTeamScores().get(team.getId()).setNoOfOvers( (noOfBalls/6) + (noOfBalls%6)/10);
        s.getTeamScores().get(team.getId()).setNoOfFours(noOfFours);
        s.getTeamScores().get(team.getId()).setNoOfSixes(noOfSixes);
        s.getTeamScores().get(team.getId()).setNoOfWickets(noOfWikcets);
    }

}
