package com.example.simplerestapis.service.team.bean;

import com.example.simplerestapis.service.player.beans.Player;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

import java.util.List;

@Data
@Document
public class Team {
    @Id
    private int id;
    private String name;
    private List<Player> players = new ArrayList<>();

    private Team(String name,int id) {
        this.name = name;
        this.id = id;
    }

    public static Team createTeamInstance(String name, int id) {
        return new Team(name,id);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

}
