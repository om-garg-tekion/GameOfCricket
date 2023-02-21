package com.CricketGame.GameOfCricket.controller;


import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.dto.MatchDTO;
import com.CricketGame.GameOfCricket.model.dtoMapper.MatchMapper;
import com.CricketGame.GameOfCricket.service.daoService.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;


    @PostMapping("/match")
    public MatchDTO addMatch(@RequestBody MatchDTO matchDTO){
        Match match = MatchMapper.toMatch(matchDTO);
        match.setId(matchService.saveMatch(match).getId());
        return MatchMapper.toDto(match);
    }
}
