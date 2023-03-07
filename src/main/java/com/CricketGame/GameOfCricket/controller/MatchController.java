package com.CricketGame.GameOfCricket.controller;


import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.dto.MatchDTO;
import com.CricketGame.GameOfCricket.service.dataAccessService.MatchService;
import com.CricketGame.GameOfCricket.service.mapper.MatchMapper;
import com.CricketGame.GameOfCricket.service.starter.MatchCreator;
import com.CricketGame.GameOfCricket.service.validator.MatchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/match")
    public ResponseEntity<MatchDTO> addMatch(@RequestBody MatchDTO matchDTO){
        Match match = MatchMapper.toMatch(matchDTO);

        match.setId(matchService.saveMatch(match).getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(MatchMapper.toMatchDto(match));
    }

    @PostMapping("/startMatch")
    public ResponseEntity<MatchDTO> startMatch(@RequestBody MatchDTO matchDTO) {
        Match match = MatchMapper.toMatch(matchDTO);

        if(MatchValidator.inputValidator(match)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Optional<Match> matchOptional = Optional.ofNullable(MatchCreator.start(match));

        return matchOptional.map(value -> ResponseEntity.ok(MatchMapper.toMatchDto(value)))
                            .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping("/match/{winnerTeamId}")
    public ResponseEntity<MatchDTO> getMatchDetailsByWinnerId(@PathVariable long winnerTeamId){
        Optional<Match> match = matchService.getMatchByWinnerId(winnerTeamId);

        return match.map(value -> ResponseEntity.ok(MatchMapper.toMatchDto(value)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
