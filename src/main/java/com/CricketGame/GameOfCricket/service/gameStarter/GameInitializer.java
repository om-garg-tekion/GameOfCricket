package com.CricketGame.GameOfCricket.service.gameStarter;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.service.dbCreator.DbCreator;
import org.springframework.stereotype.Service;

@Service
public class GameInitializer {
    public static Match initialGame(Match match) {
        MatchStarter beginMatch = new MatchStarter(match); // Initializing
        // variables and making object of required class.
        DbCreator.match = beginMatch.startMatch();
        System.out.println(DbCreator.match);
        DbCreator.init();
        return DbCreator.match;
    }
}
