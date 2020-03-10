package com.example.simplerestapis.controller;

import com.example.simplerestapis.repository.Playerrepository;
import com.example.simplerestapis.repository.Scorecardrepository;
import com.example.simplerestapis.repository.Teamrepository;
import com.example.simplerestapis.service.scorecard.bean.Scorecard;
import com.example.simplerestapis.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    private MatchController matchController;
    @Autowired
    private Scorecardrepository scorecardrepository;
    @Autowired
    private Teamrepository teamrepository;
    @Autowired
    private Playerrepository playerrepository;
    @RequestMapping("/play")
    public Scorecard match() {
        Scorecard s = matchController.playGame(scorecardrepository, teamrepository, playerrepository);
        return s;
    }
    @RequestMapping("/getmatches")
    public List<Scorecard> getMatches(){
        return scorecardrepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
    }
    @GetMapping("/teamsResult")
    @ResponseBody
    public String getTeamsResult(@RequestParam String id) {
        return "ID: " + id;
    }
}