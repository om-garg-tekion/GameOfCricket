package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.service.dataAccessService.AllService;

import static com.CricketGame.GameOfCricket.service.dataAccessService.AllService.matchService;

// MatchValidator

public class MatchValidator {
    public static boolean inputValidator(Match match){ // change name to validator
        matchService.validateMatch(match.getId());
        if (AllService.teamService.checkTeam(match.getFirstTeam().getId(), match.getId())) {
            return true;
        }
        for (Player player : match.getFirstTeam().getPlayers()) {
            if (AllService.playerService.checkPlayer(player.getId(), match.getFirstTeam().getId(), match.getId())) {
                return true;
            }
        }
        if (AllService.teamService.checkTeam(match.getSecondTeam().getId(), match.getId())) {
            return true;
        }
        for (Player player : match.getSecondTeam().getPlayers()) {
            if (AllService.playerService.checkPlayer(player.getId(), match.getSecondTeam().getId(), match.getId())) {
                return true;
            }
        }
        return false;
    }
}
