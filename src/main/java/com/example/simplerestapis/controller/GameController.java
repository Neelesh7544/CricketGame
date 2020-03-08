package com.example.simplerestapis.controller;

import com.example.simplerestapis.service.scorecard.Scorecard;
import com.example.simplerestapis.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class GameController {
    @Autowired
    private MatchController matchController;

    @RequestMapping("/play")
    public Scorecard match() {
        return matchController.playGame();
    }


}