package com.example.simplerestapis.service.player.beans;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Player {
    @Id
    private String id;
    private String name;
    private String playingRole;
    private int rating;
}
