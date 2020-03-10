package com.example.simplerestapis.service.team.util;

import com.example.simplerestapis.repository.Playerrepository;
import com.example.simplerestapis.repository.Teamrepository;
import com.example.simplerestapis.service.player.beans.Player;
import com.example.simplerestapis.service.team.bean.Team;

public class TeamUtils {
    public static void createTeam(Team team, Teamrepository teamrepository, Playerrepository playerrepository){
        int id = 0;
        for (int i = 0; i < 4; i++) {
            Player p = new Player();
            p.setName("Batsman" + i );
            p.setPlayingRole("Batsman");
            p.setRating(3);
            p.setId(team.getId() + Integer.toString(++id) );
            playerrepository.save(p);
            team.addPlayer(p);
        }
        for (int i = 0; i < 3; i++) {
            Player p = new Player();
            p.setName("All Rounder" + i);
            p.setPlayingRole("All Rounder");
            p.setRating(2);
            p.setId(team.getId() + Integer.toString(++id) );
            playerrepository.save(p);
            team.addPlayer(p);
        }
        for (int i = 0; i < 4; i++) {
            Player p = new Player();
            p.setName("Bowler" + i);
            p.setPlayingRole("Bowler");
            p.setRating(1);
            p.setId(team.getId() + Integer.toString(++id) );
            playerrepository.save(p);
            team.addPlayer(p);
        }
        teamrepository.save(team);
    }
}
