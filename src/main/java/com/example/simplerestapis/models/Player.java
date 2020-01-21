package com.example.simplerestapis.models;

import org.springframework.stereotype.Component;

@Component
public class Player extends Team{
    private long id;
    private String name;
    private int age;
    private long score;
    private long wickets;
    private String playingRole;

}
