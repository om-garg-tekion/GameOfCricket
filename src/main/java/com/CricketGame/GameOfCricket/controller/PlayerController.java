package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.Response;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;
import com.CricketGame.GameOfCricket.model.dtoMapper.PlayerMapper;
import com.CricketGame.GameOfCricket.service.daoService.AllService;
import com.CricketGame.GameOfCricket.service.daoService.PlayerService;
import com.CricketGame.GameOfCricket.service.inputChecker.PlayerInputChecker;
import com.CricketGame.GameOfCricket.service.singletonInstantiator.ResponseInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    public Response addPlayer(@RequestBody PlayerDTO playerDTO) {

        Player player = PlayerMapper.toPlayer(playerDTO);
        Response response = ResponseInstantiator.getInstance();
        if(PlayerInputChecker.checkInputs(player)){
            response.setObject(playerDTO);
            response.setStatusCode(500);
            response.setMessage("Invalid Inputs");
            return response;
        }
        player.setId(playerService.savePlayer(player).getId());
        response.setObject(PlayerMapper.toDto(player));
        response.setStatusCode(200);
        response.setMessage("Player Added");
        return response;
    }

    @PostMapping("/players")
    public Response addPlayers(@RequestBody List<PlayerDTO> playerDTOS) {
        List<PlayerDTO> players = new ArrayList<>();
        Response response = ResponseInstantiator.getInstance();
        for(PlayerDTO playerDTO : playerDTOS){
            Player player = PlayerMapper.toPlayer(playerDTO);
            if(PlayerInputChecker.checkInputs(player)){
                response.setObject(playerDTO);
                response.setStatusCode(403);
                response.setMessage("Invalid Inputs");
                return response;
            }
            player.setId(playerService.savePlayer(player).getId());
            players.add(PlayerMapper.toDto(player));
        }
        response.setObject(players);
        response.setStatusCode(201);
        response.setMessage("Players Added");
        return response;
    }

}
