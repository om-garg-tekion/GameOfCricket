package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamValidatorImp implements TeamValidator {
    @Autowired
    private MatchService matchService;

    @Override
    public boolean inputValidator(Team team){
        return matchService.validateMatch(team.getMatchId());
    }
}
