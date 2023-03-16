package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.PlayerService;
import com.CricketGame.GameOfCricket.service.mapper.PlayerMapper;
import com.CricketGame.GameOfCricket.service.validator.playerValidator.PlayerValidator;
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

    @Autowired
    private PlayerValidator playerValidator;

    /** Add players in the database
     * @param playerDTOS players that are to be added in the database
     */
    @PostMapping("/create")
    public ResponseEntity<List<PlayerDTO>> addPlayers(@RequestBody List<PlayerDTO> playerDTOS) {
        List<PlayerDTO> players = new ArrayList<>();

        for(PlayerDTO playerDTO : playerDTOS){
            if(playerValidator.inputValidator(playerDTO)){
                return ResponseEntity.notFound().build();
            }

            Player player = PlayerMapper.toPlayer(playerDTO);
            player.setId(playerService.savePlayer(player).getId());
            players.add(PlayerMapper.toPlayerDto(player));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(players);
    }

    /** gets player record from the database
     * @param teamId id of the team that is used to retrieve data.
     * @param matchId id of the match that is used to retrieve data.
     * @param playerId id of the player that need to be retrieved.
     * @return required Player record and if player with required id is not present then it throws not found http
     * response.
     */
    @GetMapping("/{playerId}/{teamId}/{matchId}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable("playerId") long playerId,
                                                @PathVariable("teamId") long teamId,
                                                @PathVariable("matchId") long matchId){
        Optional<Player> player = playerService.findById(playerId, teamId, matchId);
        return player.map(value -> ResponseEntity.ok(PlayerMapper.toPlayerDto(value)))
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }


    /** gets player(s) record from the database
     * @param name name of the team that need to be retrieved
     * @return required Player record and if player with required name is not present then it throws not found http
     * response.
     */
    @GetMapping("/name/{name}")
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


    /** gets team record from the database
     * @param battingOrderNumber retrieve players according to batting order number.
     * @param teamId is used to retrieve player for a particular team.
     * @return required Player record and if player with required parameters is not present then it throws not found
     * http response.
     */
    @GetMapping("/battingOrderNumber/{teamId}/{battingOrderNumber}")
    public ResponseEntity<PlayerDTO> getPlayerByBattingOrderNumber(@PathVariable("teamId") long teamId, @PathVariable(
            "battingOrderNumber") int battingOrderNumber){
        Optional<Player> player = playerService.getPlayerByBattingOrderNumber(battingOrderNumber, teamId);
        return player.map(value -> ResponseEntity.ok(PlayerMapper.toPlayerDto(value)))
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
