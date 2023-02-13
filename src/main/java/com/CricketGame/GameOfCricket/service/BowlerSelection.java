package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Player;
import com.CricketGame.GameOfCricket.model.classes.Team;

import java.util.Optional;
import java.util.Random;


public class BowlerSelection {
    private static final Random randomNumberGenerator = RandomNumberGenerator.getInstance();

    public static Player chooseBowler(Team team, Optional<Player> currentBowler){
        int sizeOfTeam = team.getPlayers().size();

        Player selectedBowler;

        do {
            selectedBowler = team.getPlayers().get(randomNumberGenerator.nextInt(sizeOfTeam));
        } while (currentBowler.isPresent() && selectedBowler == currentBowler.get());

        return selectedBowler;
    }
}


