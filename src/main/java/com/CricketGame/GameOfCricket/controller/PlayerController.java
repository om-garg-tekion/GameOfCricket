package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;
import com.CricketGame.GameOfCricket.model.dtoMapper.PlayerMapper;
import com.CricketGame.GameOfCricket.service.daoService.PlayerService;
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
    public PlayerDTO addPlayer(@RequestBody PlayerDTO playerDTO) {
        Player player = PlayerMapper.toPlayer(playerDTO);
        player.setId(playerService.savePlayer(player).getId());
        return PlayerMapper.toDto(player);
    }

    @PostMapping("/players")
    public List<PlayerDTO> addPlayers(@RequestBody List<PlayerDTO> playerDTOS) {
        List<PlayerDTO> players = new ArrayList<>();
        for(PlayerDTO playerDTO : playerDTOS){
            Player player = PlayerMapper.toPlayer(playerDTO);
            player.setId(playerService.savePlayer(player).getId());
            players.add(PlayerMapper.toDto(player));
        }
        return players;
    }

}
