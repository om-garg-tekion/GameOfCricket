package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;

public class ValidatePlayerRoleUtilsTest {

    public PlayerDTO getPlayerDto(){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlayerRole("BATSMAN");
        return playerDTO;
    }

}
