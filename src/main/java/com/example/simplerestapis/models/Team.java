package com.example.simplerestapis.models;

import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class Team  {
    Team[] team = new Player[11];
    HashMap<Integer,Integer> teamMap = new HashMap<>();
    public int  playInning(){
        CricketGame game = new CricketGame();
        return game.start(teamMap);
    }
}
