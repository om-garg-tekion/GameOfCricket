package com.CricketGame.GameOfCricket.service.validator.playerValidator;

import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.MatchService;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.TeamService;
import com.CricketGame.GameOfCricket.service.validator.ValidatePlayerRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerValidatorImp implements PlayerValidator {
    @Autowired
    private MatchService matchService;
    @Autowired
    private TeamService teamService;

    @Override
    public boolean inputValidator(PlayerDTO player){
        if(matchService.validateMatch(player.getMatchId())){
            return true;
        } else if(teamService.validateTeam(player.getTeamId(), player.getMatchId())){
            return !ValidatePlayerRole.isValid(player);
        }
        return true;
    }
}
