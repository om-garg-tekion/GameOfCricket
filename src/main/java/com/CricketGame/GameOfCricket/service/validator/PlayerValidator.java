package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.service.dataAccessService.AllService;

public class PlayerValidator {
    public static boolean inputValidator(Player player){
        if(!AllService.matchService.validateMatch(player.getMatchId())){
            return true;
        } else return !AllService.teamService.validateTeam(player.getTeamId(), player.getMatchId());
    }
}
