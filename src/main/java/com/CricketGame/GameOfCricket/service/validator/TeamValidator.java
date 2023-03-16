package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessServices.AllService;

public class TeamValidator {
    public static boolean inputValidator(Team team){
        return AllService.matchService.validateMatch(team.getMatchId());
    }
}
