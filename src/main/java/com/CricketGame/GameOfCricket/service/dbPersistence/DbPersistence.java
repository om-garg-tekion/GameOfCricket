package com.CricketGame.GameOfCricket.service.dbPersistence;

import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;

public interface DbPersistence {
    
    void init(Match match);

    void setUpMatchEntity(Match match);

    void setUpPlayerEntity(Team team);

    void setUpTeamEntity(Team team);

    void setUpBatsmanStats(Team team);

    void setUpBowlerStats(Team team);

    void setUpIdsForMatchEntity(Match match);

    Innings setUpInningsEntity(Match match, Innings innings, boolean isFirstInning);

    void setUpBallEntity(Match match, Innings innings);
}
