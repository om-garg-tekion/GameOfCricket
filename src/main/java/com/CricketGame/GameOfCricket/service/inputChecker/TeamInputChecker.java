package com.CricketGame.GameOfCricket.service.inputChecker;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.service.daoService.AllService;

public class TeamInputChecker {
    public static boolean checkInputs(Team team){
        if(AllService.matchService.checkMatch(team.getMatchId())){
            return true;
        }
        return false;
    }
}
