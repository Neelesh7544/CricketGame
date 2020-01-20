package com.example.simplerestapis.controller;
import com.example.simplerestapis.models.CricketGame;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @RequestMapping("/match")
    public CricketGame Sample() {
        CricketGame response = new CricketGame();
        response.start();
        response.Result();
        return response;
    }
}