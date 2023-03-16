package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;
import com.CricketGame.GameOfCricket.service.dataAccessService.PlayerService;
import com.CricketGame.GameOfCricket.service.mapper.PlayerMapper;
import com.CricketGame.GameOfCricket.service.validator.PlayerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<List<PlayerDTO>> addPlayers(@RequestBody List<PlayerDTO> playerDTOS) {
        List<PlayerDTO> players = new ArrayList<>();

        for(PlayerDTO playerDTO : playerDTOS){
            if(PlayerValidator.inputValidator(playerDTO)){
                return ResponseEntity.notFound().build();
            }

            Player player = PlayerMapper.toPlayer(playerDTO);
            player.setId(playerService.savePlayer(player).getId());
            players.add(PlayerMapper.toPlayerDto(player));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(players);
    }

    @GetMapping("/{playerId}/{teamId}/{matchId}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable("playerId") long playerId,
                                                @PathVariable("teamId") long teamId,
                                                @PathVariable("matchId") long matchId){
        Optional<Player> player = playerService.findById(playerId, teamId, matchId);
        return player.map(value -> ResponseEntity.ok(PlayerMapper.toPlayerDto(value)))
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PlayerDTO>> getPlayerByName(@PathVariable("name") String name){
        Optional<List<Player>> players = playerService.getPlayerByName(name);
        if(players.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            List<PlayerDTO> playerDTO = new ArrayList<>();
            for(Player player : players.get()){
                playerDTO.add(PlayerMapper.toPlayerDto(player));
            }
            return ResponseEntity.ok(playerDTO);
        }
    }

    @GetMapping("/{teamId}/{battingOrderNumber}")
    public ResponseEntity<PlayerDTO> getPlayerByBattingOrderNumber(@PathVariable("teamId") long teamId, @PathVariable(
            "battingOrderNumber") int battingOrderNumber){
        Optional<Player> player = playerService.getPlayerByBattingOrderNumber(battingOrderNumber, teamId);
        return player.map(value -> ResponseEntity.ok(PlayerMapper.toPlayerDto(value)))
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
