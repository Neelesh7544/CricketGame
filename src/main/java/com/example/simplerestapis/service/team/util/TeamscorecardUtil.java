package com.example.simplerestapis.service.team.util;


import com.example.simplerestapis.service.team.bean.Teamscorecard;

public class TeamscorecardUtil {


    public static void incrementFours(Teamscorecard battingteamscorecard) {
        battingteamscorecard.setNoOfFours(battingteamscorecard.getNoOfFours() + 1);
    }
    public static void incrementSixes(Teamscorecard battingteamscorecard){
        battingteamscorecard.setNoOfSixes(battingteamscorecard.getNoOfSixes() + 1);
    }

    public static void incrementWickets(Teamscorecard battingteamscorecard) {
        battingteamscorecard.setNoOfWickets(battingteamscorecard.getNoOfWickets() + 1);
    }
}
