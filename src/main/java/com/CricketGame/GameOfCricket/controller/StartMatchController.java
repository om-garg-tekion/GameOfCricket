package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.dto.MatchDTO;
import com.CricketGame.GameOfCricket.model.dtoMapper.MatchMapper;
import com.CricketGame.GameOfCricket.service.daoService.MatchService;
import com.CricketGame.GameOfCricket.service.gameStarter.MatchCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartMatchController {

    @Autowired
    private MatchService matchService;


//    @PostMapping("/startMatch")
//    public MatchDTO startMatch(@RequestBody Match match) {
//        return MatchCreator.start(match);
//    }

    @PostMapping("/startMatch")
    public MatchDTO startMatch(@RequestBody MatchDTO matchDTO){
        Match match = MatchMapper.toMatch(matchDTO);
        return MatchMapper.toDto(MatchCreator.start(match));
    }
}
