package com.example.simplerestapis.services;

import com.example.simplerestapis.beans.Player;
import com.example.simplerestapis.beans.Scorecard;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class Team {
    private int id;
    private String name;
    private List<Player> players = new ArrayList<>();
    private HashMap<Integer, Integer> teamScoreMap = new HashMap<>();

    private Team(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static Team createTeamInstance(String name,int id) {
        Team team = new Team(name,id);
        return team;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public int playInning(Team a, Team b, int temp, Scorecard s) {
        CricketGame game = new CricketGame();
        return game.start(teamScoreMap, a, b, temp, s);
    }

}
