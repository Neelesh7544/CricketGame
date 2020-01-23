package com.example.simplerestapis.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class Team<T extends Player> {
    String name;
    List<T> players = new ArrayList<>();
    HashMap<Integer, Integer> teamMap = new HashMap<>();

    public String getName() {
        return name;
    }

    public List<T> getPlayers() {
        return this.players;
    }

    public boolean addPlayer(T player) {
        if (!players.contains(player)) {
            this.players.add(player);
            return true;
        }
        return false;
    }

    public int playInning(Team a, Team b, int temp) {
        CricketGame game = new CricketGame();
        return game.start(teamMap, a, b, temp);
    }

    public void setName(String s) {
        this.name = s;
    }
}
