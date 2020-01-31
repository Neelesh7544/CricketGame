package com.example.simplerestapis.util;

import com.example.simplerestapis.beans.Player;
import com.example.simplerestapis.services.Team;

public class CreateTeamUtil {
    public static Team createTeam(Team team){
        int id = 0;
        for (int i = 0; i < 4; i++) {
            Player p = new Player();
            p.setId(++id);
            p.setName("ABC");
            p.setPlayingRole("Batsman");
            p.setRating(3);
            team.addPlayer(p);
        }
        for (int i = 0; i < 3; i++) {
            Player p = new Player();
            p.setId(++id);
            p.setName("ABC");
            p.setPlayingRole("All Rounder");
            p.setRating(2);
            team.addPlayer(p);
        }
        for (int i = 0; i < 4; i++) {
            Player p = new Player();
            p.setName("ABC");
            p.setId(++id);
            p.setPlayingRole("Bowler");
            p.setRating(1);
            team.addPlayer(p);
        }
        return team;

    }
}
