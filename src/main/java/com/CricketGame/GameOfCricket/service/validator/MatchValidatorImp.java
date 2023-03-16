package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.PlayerService;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MatchValidatorImp implements MatchValidator {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @Override
    public boolean inputValidator(Match match){
        if (!teamService.validateTeam(match.getFirstTeam().getId(), match.getId())) {
            return true;
        }
        for (Player player : match.getFirstTeam().getPlayers()) {
            if (playerService.validatePlayer(player.getId(), match.getFirstTeam().getId(), match.getId())) {
                return true;
            }
        }
        if (!teamService.validateTeam(match.getSecondTeam().getId(), match.getId())) {
            return true;
        }
        for (Player player : match.getSecondTeam().getPlayers()) {
            if (playerService.validatePlayer(player.getId(), match.getSecondTeam().getId(), match.getId())) {
                return true;
            }
        }
        if(Objects.equals(match.getFirstTeam().getId(), match.getSecondTeam().getId())){
            return true;
        }
        return false;
    }
}
