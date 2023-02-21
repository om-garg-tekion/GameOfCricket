package com.CricketGame.GameOfCricket.model.dtoMapper;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;

public class PlayerMapper {
    public static Player toPlayer(PlayerDTO playerDTO){
        Player player = new Player();
        player.setPlayerRole(playerDTO.getPlayerRole());
        player.setName(playerDTO.getName());
        player.setMatchId(playerDTO.getMatchId());
        player.setTeamId(playerDTO.getTeamId());
        player.setBattingOrderNumber(playerDTO.getBattingOrderNumber());
        return player;
    }
    public static PlayerDTO toDto(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setPlayerRole(player.getPlayerRole());
        playerDTO.setName(player.getName());
        playerDTO.setMatchId(player.getMatchId());
        playerDTO.setTeamId(player.getTeamId());
        return playerDTO;
    }
}
