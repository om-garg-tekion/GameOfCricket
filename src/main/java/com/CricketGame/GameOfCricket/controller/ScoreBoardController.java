package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.dto.MatchDTO;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.MatchService;
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

    /** gets match record from the database
     * @param id id of the match that need to be retrieved
     * @return required Match record and if match with required id is not present then it throws not found http
     * response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<MatchDTO> getScoreBoard(@PathVariable("id") long id){
        Optional<Match> match = matchService.getScoreBoardByMatchId(id);

        return match.map(value -> ResponseEntity.ok(MatchMapper.toMatchDto(value)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
