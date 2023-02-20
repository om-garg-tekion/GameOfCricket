package com.CricketGame.GameOfCricket.controller;


import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.service.dao_service.MatchService;
import com.CricketGame.GameOfCricket.service.match_activity.MatchCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;


    @PostMapping("/match")
    public Match addMatch(@RequestBody Match match){
        matchService.saveMatch(match);
        return matchService.saveMatch(MatchCreation.start(matchService.saveMatch(match)));
    }
}
