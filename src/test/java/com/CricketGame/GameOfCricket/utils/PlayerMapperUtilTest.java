package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;
import com.CricketGame.GameOfCricket.model.enums.Role;

import java.util.OptionalLong;

public class PlayerMapperUtilTest {

    public Player getPlayer(OptionalLong id, Long matchId, Long teamId, OptionalLong batsmanStatsId,
                            OptionalLong bowlerStatsId, String name,
                            String playerRole,
                            int battingOrderNumber){
        Player player = new Player();
        if(id.isPresent()){
            player.setId(id.getAsLong());
        }
        if(batsmanStatsId.isPresent()){
            player.setBatsmanStatsId(batsmanStatsId.getAsLong());
        }
        if(bowlerStatsId.isPresent()){
            player.setBowlingStatsId(bowlerStatsId.getAsLong());
        }
        player.setPlayerRole(Role.valueOf(playerRole));
        player.setName(name);
        player.setMatchId(matchId);
        player.setTeamId(teamId);
        player.setBattingOrderNumber(battingOrderNumber);
        return player;
    }

    public PlayerDTO getPlayerDTO(Long id, Long matchId, Long teamId, Long batsmanStatsId,
                                  Long bowlerStatsId, String name, Role playerRole,
                                  int battingOrderNumber){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(id);
        playerDTO.setPlayerRole(playerRole.getDisplayValue());
        playerDTO.setName(name);
        playerDTO.setMatchId(matchId);
        playerDTO.setTeamId(teamId);
        playerDTO.setBatsmanStatsId(batsmanStatsId);
        playerDTO.setBowlingStatsId(bowlerStatsId);
        playerDTO.setBattingOrderNumber(battingOrderNumber);
        return playerDTO;
    }
}
