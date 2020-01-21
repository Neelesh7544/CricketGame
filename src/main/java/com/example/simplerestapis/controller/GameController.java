package com.example.simplerestapis.controller;
import com.example.simplerestapis.models.CricketGame;
import com.example.simplerestapis.models.MatchController;
import com.example.simplerestapis.models.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @RequestMapping("/match")
    public Result Match() {
        MatchController m = new MatchController();
        m.playGame();
        Result r = m.finishGame();
        return r;
    }
}