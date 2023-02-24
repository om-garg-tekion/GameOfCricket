package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.dto.Response;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;
import com.CricketGame.GameOfCricket.service.mapper.PlayerMapper;
import com.CricketGame.GameOfCricket.service.dataAccessService.PlayerService;
import com.CricketGame.GameOfCricket.service.responseBuilder.ResponseBuilder;
import com.CricketGame.GameOfCricket.service.validator.PlayerValidator;
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

        if(PlayerValidator.inputValidator(player)){
            return ResponseBuilder.responseBuilder(playerDTO, 403, "Invalid Inputs");
        }

        player.setId(playerService.savePlayer(player).getId());

        return ResponseBuilder.responseBuilder(PlayerMapper.toPlayerDto(player), 201, "Player Added");
    }

    @PostMapping("/players")
    public Response addPlayers(@RequestBody List<PlayerDTO> playerDTOS) {
        List<PlayerDTO> players = new ArrayList<>();

        for(PlayerDTO playerDTO : playerDTOS){
            Player player = PlayerMapper.toPlayer(playerDTO);

            if(PlayerValidator.inputValidator(player)){
                return ResponseBuilder.responseBuilder(playerDTO, 403, "Invalid Inputs");
            }

            player.setId(playerService.savePlayer(player).getId());
            players.add(PlayerMapper.toPlayerDto(player));
        }

        return ResponseBuilder.responseBuilder(players, 201, "Players Added");
    }

}
