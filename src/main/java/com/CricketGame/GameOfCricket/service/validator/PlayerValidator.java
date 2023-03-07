package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;
import com.CricketGame.GameOfCricket.service.dataAccessService.AllService;

public class PlayerValidator {
    public static boolean inputValidator(PlayerDTO player){
        if(AllService.matchService.validateMatch(player.getMatchId())){
            return true;
        } else if(AllService.teamService.validateTeam(player.getTeamId(), player.getMatchId())){
            return !ValidatePlayerRole.isValid(player);
        }
        return true;
    }
}
