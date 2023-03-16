package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.dto.MatchDTO;
import com.CricketGame.GameOfCricket.service.dataAccessService.MatchService;
import com.CricketGame.GameOfCricket.service.mapper.MatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/scoreBoard")
public class ScoreBoardController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/{id}")
    public ResponseEntity<MatchDTO> getMatchDetailsByWinnerId(@PathVariable("id") long id){
        Optional<Match> match = matchService.getScoreBoardByMatchId(id);

        System.out.println(match);

        return match.map(value -> ResponseEntity.ok(MatchMapper.toMatchDto(value)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
