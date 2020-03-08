package com.example.simplerestapis.service.team;

import com.example.simplerestapis.service.player.beans.Player;
import com.example.simplerestapis.service.scorecard.Playerscorecard;
import lombok.Data;

import java.util.HashMap;

@Data
public class Teamscorecard {
    private int teamScore;
    private int noOfWickets;
    private int noOfFours;
    private int noOfSixes;
    private HashMap<Player, Playerscorecard> playerScores = new HashMap<>();
}
