package com.example.simplerestapis;

import com.example.simplerestapis.controller.GameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class GameCricket {

    public static void main(String[] args) {

        SpringApplication.run(GameCricket.class, args);
    }
}
