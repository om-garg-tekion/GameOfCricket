package com.CricketGame.GameOfCricket.service.inputChecker;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.service.daoService.AllService;
import com.CricketGame.GameOfCricket.utils.Constants;

public class PlayerInputChecker {
    public static boolean checkInputs(Player player){
        if(AllService.matchService.checkMatch(player.getMatchId())){
            return true;
        } else if (AllService.teamService.checkTeam(player.getTeamId(), player.getMatchId())) {
            return true;
        }
        return false;
    }
}
