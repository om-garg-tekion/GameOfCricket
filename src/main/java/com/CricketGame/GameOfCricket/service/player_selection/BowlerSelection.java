package com.CricketGame.GameOfCricket.service.player_selection;

import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.model.entities.player.Player;
import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import com.CricketGame.GameOfCricket.service.singleton_instantiation.RandomNumberGenerator;

import java.util.Optional;
import java.util.Random;


public class BowlerSelection {
    private static final Random randomNumberGenerator = RandomNumberGenerator.getInstance();

    public static Player chooseBowler(Team team, Optional<Player> currentBowler){
        int sizeOfTeam = team.getPlayers().size();

        Player selectedBowler;

        do {
            selectedBowler = team.getPlayers().get(randomNumberGenerator.nextInt(sizeOfTeam));
            if(PlayerRole.BOWLER.equals(selectedBowler.getPlayerRole())) {
                if (currentBowler.isPresent()) {
                    if (!selectedBowler.equals(currentBowler.get())) {
                        break;
                    }
                } else {
                    break;
                }
            }
        } while (true);

        return selectedBowler;
    }
}

