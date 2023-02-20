package com.CricketGame.GameOfCricket.service.match_activity;

import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.service.SetUpDB;
import org.springframework.stereotype.Service;

@Service
public class SetUpGame {
    public static void initialGame(Match match) {
        BeginMatch beginMatch = new BeginMatch(match); // Initializing
        // variables and making object of required class.
        SetUpDB.match = beginMatch.startMatch();
        System.out.println(SetUpDB.match);
        SetUpDB.init();
    }
}
