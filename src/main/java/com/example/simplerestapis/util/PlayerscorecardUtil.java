package com.example.simplerestapis.util;

import com.example.simplerestapis.beans.Player;
import com.example.simplerestapis.beans.Playerscorecard;

public class PlayerscorecardUtil
{
    public static void incrementOvers(Playerscorecard ps,float over){
        ps.setNumOfOvers(ps.getNumOfOvers() + over);
    }
    public static void incrementMaidenOvers(Playerscorecard ps){
        ps.setMaidenOvers(ps.getMaidenOvers() +1);
    }
    public static void incrementNoOfBallsPlayed(Playerscorecard ps){
        ps.setNumberOfBallsPlayed(ps.getNumberOfBallsPlayed() + 1);
    }
    public static void incrementWicktesTaken(Playerscorecard ps){
        ps.setWicketsTaken(ps.getWicketsTaken() + 1);
    }
    public static void incrementRunsScored(Playerscorecard ps, int runs){
        ps.setRunsScored(ps.getRunsScored() + runs);
    }

    public static void incrementRunsGiven(Playerscorecard ps, int runs){
        ps.setRunsGiven(ps.getRunsGiven() + runs);
    }
    public static void incrementBoundaries(Playerscorecard ps){
        ps.setNumberOfBoundaries(ps.getNumberOfBoundaries() + 1);
    }
}
