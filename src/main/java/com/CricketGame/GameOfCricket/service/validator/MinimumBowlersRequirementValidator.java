package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.constants.Constants;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.enums.Role;

public class MinimumBowlersRequirementValidator{
    public static boolean isValid(Team team) {
        int bowlers = Constants.INITIAL_NUMBER_OF_PLAYERS;
        for(Player player: team.getPlayers()){
            if(Role.BOWLER.equals(player.getPlayerRole())) bowlers++;
        }
        return bowlers < Constants.MINIMUM_NUMBER_OF_BOWLER;
    }

}
