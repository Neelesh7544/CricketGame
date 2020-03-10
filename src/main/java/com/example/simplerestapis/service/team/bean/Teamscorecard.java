package com.example.simplerestapis.service.team.bean;

import com.example.simplerestapis.service.player.beans.Player;
import com.example.simplerestapis.service.player.beans.Playerscorecard;
import lombok.Data;

import java.util.HashMap;
import java.util.TreeMap;

@Data
public class Teamscorecard {
    private int teamScore;
    private int noOfWickets;
    private int noOfFours;
    private int noOfSixes;
    private HashMap<String, Playerscorecard> playerScores = new HashMap<>();
}
