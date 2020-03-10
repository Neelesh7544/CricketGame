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
    @RequestMapping("/teamsresult")
    @ResponseBody
    public String getTeamsResult(@RequestParam String id) {
        List<Scorecard> wonmatches = scorecardrepository.findBywinner(id);
        List<Scorecard> lostmatches = scorecardrepository.findBywinnerNot(id);
        List<Scorecard> drawmatches = scorecardrepository.findBywinner("Match Tied");
        int won = wonmatches.size();
        int lost = lostmatches.size();
        int draw = drawmatches.size();
        return "Won :" + won + "Lost :" + lost + "Draw :" + draw;
    }
}