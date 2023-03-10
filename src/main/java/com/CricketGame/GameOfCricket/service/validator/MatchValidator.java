package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.service.dataAccessService.AllService;

import java.util.Objects;

public class MatchValidator {
    public static boolean inputValidator(Match match){ // change name to validator
        if (!AllService.teamService.validateTeam(match.getFirstTeam().getId(), match.getId())) {
            return true;
        }
        for (Player player : match.getFirstTeam().getPlayers()) {
            if (AllService.playerService.validatePlayer(player.getId(), match.getFirstTeam().getId(), match.getId())) {
                return true;
            }
        }
        if (!AllService.teamService.validateTeam(match.getSecondTeam().getId(), match.getId())) {
            return true;
        }
        for (Player player : match.getSecondTeam().getPlayers()) {
            if (AllService.playerService.validatePlayer(player.getId(), match.getSecondTeam().getId(), match.getId())) {
                return true;
            }
        }
        if(Objects.equals(match.getFirstTeam().getId(), match.getSecondTeam().getId())){
            return true;
        }
        return false;
    }
}
