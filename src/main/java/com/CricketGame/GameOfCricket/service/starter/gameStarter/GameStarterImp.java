package com.CricketGame.GameOfCricket.service.starter.gameStarter;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.service.dbPersistence.DbPersistence;
import com.CricketGame.GameOfCricket.service.starter.matchStarter.MatchStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameStarterImp implements GameStarter {
    @Autowired
    private MatchStarter matchStarter;
    @Autowired
    private DbPersistence dbPersistence;

    @Override
    public Match startGame(Match match) {
        match = matchStarter.matchInit(match);
        matchStarter.startMatch(match, match.getFirstInnings(), match.getSecondInnings(),
                match.getFirstTeam(), match.getSecondTeam());
        dbPersistence.init(match);
        return match;
    }
}
