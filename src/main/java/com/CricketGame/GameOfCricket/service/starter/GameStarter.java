package com.CricketGame.GameOfCricket.service.starter;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.service.dbPersistence.DbPersistence;
import org.springframework.stereotype.Service;

public class GameStarter {
    public static Match startGame(Match match) {
        MatchStarter beginMatch = new MatchStarter(match); // Initializing
        DbPersistence.match = beginMatch.startMatch();
        DbPersistence.init();
        return DbPersistence.match;
    }
}
