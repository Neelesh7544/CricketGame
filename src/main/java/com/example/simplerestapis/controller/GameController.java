package com.example.simplerestapis.controller;

import com.example.simplerestapis.beans.Scorecard;
import com.example.simplerestapis.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class GameController {
    @Autowired
    private MatchController m;

    @RequestMapping("/match")
    public Scorecard match() {
        m.playGame();
        return m.finishGame();
    }
}