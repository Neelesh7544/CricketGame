package com.example.simplerestapis.service.player.beans;

import lombok.Data;

@Data
public class Playerscorecard {
    private int runsScored;
    private int numberOfBallsPlayed;
    private int numberOfBoundaries;
    private float numOfOvers;
    private int runsGiven;
    private int wicketsTaken;
    private int maidenOvers;
}
