package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.Response;
import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.dto.MatchDTO;
import com.CricketGame.GameOfCricket.model.dtoMapper.MatchMapper;
import com.CricketGame.GameOfCricket.service.daoService.AllService;
import com.CricketGame.GameOfCricket.service.daoService.MatchService;
import com.CricketGame.GameOfCricket.service.gameStarter.MatchCreator;
import com.CricketGame.GameOfCricket.service.inputChecker.StartMatchInputChecker;
import com.CricketGame.GameOfCricket.service.singletonInstantiator.ResponseInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartMatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/startMatch")
    public Response startMatch(@RequestBody MatchDTO matchDTO) {
        Match match = MatchMapper.toMatch(matchDTO);
        Response response = ResponseInstantiator.getInstance();
        if(StartMatchInputChecker.checkInputs(match)){
            response.setObject(matchDTO);
            response.setMessage("Invalid Inputs");
            response.setStatusCode(403);
            return response;
        }
        response.setObject(MatchMapper.toDto(MatchCreator.start(match)));
        response.setMessage("Match is played");
        response.setStatusCode(200);
        return response;
    }
}
