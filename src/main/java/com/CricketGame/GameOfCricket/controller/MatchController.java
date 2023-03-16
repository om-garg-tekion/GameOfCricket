package com.CricketGame.GameOfCricket.controller;


import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.dto.MatchDTO;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.MatchService;
import com.CricketGame.GameOfCricket.service.mapper.MatchMapper;
import com.CricketGame.GameOfCricket.service.starter.MatchCreator;
import com.CricketGame.GameOfCricket.service.validator.MatchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    /** Add match in the database
     * @param matchDTO match that is to be added in the database.
     */
    @PostMapping("/create")
    public ResponseEntity<MatchDTO> addMatch(@RequestBody MatchDTO matchDTO){
        Match match = MatchMapper.toMatch(matchDTO);

        match.setId(matchService.saveMatch(match).getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(MatchMapper.toMatchDto(match));
    }

    /** Start match
     * @param matchDTO matchDTO with required ids of match, teams and players are used to play match.
     * @return matchDTO with all the required details.
     */
    @PostMapping("/start")
    public ResponseEntity<MatchDTO> startMatch(@RequestBody MatchDTO matchDTO) {
        Match match = MatchMapper.toMatch(matchDTO);

        if(MatchValidator.inputValidator(match)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Optional<Match> matchOptional = Optional.ofNullable(MatchCreator.start(match));

        return matchOptional.map(value -> ResponseEntity.ok(MatchMapper.toMatchDto(value)))
                            .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    /** gets match record from the database
     * @param id id of the match that is used to retrieve data.
     * @return required Match record and if match with required id is not present then it throws not found http
     * response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<MatchDTO> getMatchById(@PathVariable("id") long id){
        Match match = matchService.findById(id);
        if(Objects.isNull(match)){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(MatchMapper.toMatchDto(match));
        }
    }

    /** gets match record from the database
     * @param winnerTeamId id of the winning team that is used to retrieve data.
     * @return required Match record and if match with required parameter is not present then it throws not found http
     * response.
     */
    @GetMapping("/winnerId/{winnerTeamId}")
    public ResponseEntity<MatchDTO> getMatchDetailsByWinnerId(@PathVariable("winnerTeamId") long winnerTeamId){
        Optional<Match> match = matchService.getMatchByWinnerId(winnerTeamId);

        System.out.println(match);

        return match.map(value -> ResponseEntity.ok(MatchMapper.toMatchDto(value)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
