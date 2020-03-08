package com.example.simplerestapis.service.scorecard;

import org.jetbrains.annotations.NotNull;

public class PlayerscorecardUtil
{
    public static void incrementOvers(@NotNull Playerscorecard ps, float over){
        ps.setNumOfOvers(ps.getNumOfOvers() + over);
    }
    public static void incrementMaidenOvers(@NotNull Playerscorecard ps){
        ps.setMaidenOvers(ps.getMaidenOvers() +1);
    }
    public static void incrementNoOfBallsPlayed(@NotNull Playerscorecard ps){
        ps.setNumberOfBallsPlayed(ps.getNumberOfBallsPlayed() + 1);
    }
    public static void incrementWicktesTaken(@NotNull Playerscorecard ps){
        ps.setWicketsTaken(ps.getWicketsTaken() + 1);
    }
    public static void incrementRunsScored(@NotNull Playerscorecard ps, int runs){
        ps.setRunsScored(ps.getRunsScored() + runs);
    }

    public static void incrementRunsGiven(@NotNull Playerscorecard ps, int runs){
        ps.setRunsGiven(ps.getRunsGiven() + runs);
    }
    public static void incrementBoundaries(@NotNull Playerscorecard ps){
        ps.setNumberOfBoundaries(ps.getNumberOfBoundaries() + 1);
    }
}
