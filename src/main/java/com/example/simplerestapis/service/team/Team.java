package com.example.simplerestapis.service.team;

import com.example.simplerestapis.service.player.beans.Player;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class Team {
    private int id;
    private String name;
    private List<Player> players = new ArrayList<>();

    private Team(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static Team createTeamInstance(String name, int id) {
        return new Team(name, id);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

}
