package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.*;

import java.util.Random;

public class BowlerService {
    private static final Random random = new Random();

    public static Player chooseBowler(Team team, Player... currentBowler){
        int sizeOfTeam = team.getPlayers().size();
        Player selectedBowler;

        do {
            selectedBowler = team.getPlayers().get(random.nextInt(sizeOfTeam));
        } while (currentBowler.length != 0 && selectedBowler == currentBowler[0]);

        return selectedBowler;
    }
}

