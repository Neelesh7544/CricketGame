package com.example.simplerestapis.beans;

import lombok.Data;
import java.util.TreeMap;

@Data
public class Teamscorecard {
    private int teamScore;
    private float noOfOvers;
    private int noOfWickets;
    private int noOfFours;
    private int noOfSixes;
    private TreeMap<Integer,Playerscorecard> playerScores;
}
