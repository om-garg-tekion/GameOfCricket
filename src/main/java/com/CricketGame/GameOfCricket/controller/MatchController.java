package com.CricketGame.GameOfCricket.controller;


import com.CricketGame.GameOfCricket.model.dto.Response;
import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.dto.MatchDTO;
import com.CricketGame.GameOfCricket.service.mapper.MatchMapper;
import com.CricketGame.GameOfCricket.service.dataAccessService.MatchService;
import com.CricketGame.GameOfCricket.service.responseBuilder.ResponseBuilder;
import com.CricketGame.GameOfCricket.service.starter.MatchCreator;
import com.CricketGame.GameOfCricket.service.validator.MatchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/match")
    public Response addMatch(@RequestBody MatchDTO matchDTO){
        Match match = MatchMapper.toMatch(matchDTO);

        match.setId(matchService.saveMatch(match).getId());

        return ResponseBuilder.responseBuilder(MatchMapper.toMatchDto(match), 201, "Match is Added");
    }

    @PostMapping("/startMatch")
    public Response startMatch(@RequestBody MatchDTO matchDTO) {
        Match match = MatchMapper.toMatch(matchDTO);

        if(MatchValidator.inputValidator(match)){
            return ResponseBuilder.responseBuilder(matchDTO, 403,"Invalid Inputs");
        }

        return ResponseBuilder.responseBuilder(MatchMapper.toMatchDto(MatchCreator.start(match)), 200,"Match is " +
                                                                                                      "played");
    }
}
