package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.service.dao_service.MatchService;
import com.CricketGame.GameOfCricket.service.match_activity.MatchCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartMatchController {

    @Autowired
    private MatchService matchService;


    @GetMapping("/startMatch")
    public Match addMatch(@RequestBody Match match) {
        return MatchCreation.start(match);
    }
}
