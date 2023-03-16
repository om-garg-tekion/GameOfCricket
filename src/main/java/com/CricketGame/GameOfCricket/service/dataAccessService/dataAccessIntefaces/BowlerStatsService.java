package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces;

import com.CricketGame.GameOfCricket.model.beans.player.Bowler;

public interface BowlerStatsService {

    /** Saving bowler stats.
     * @param bowler stats that need to be saved.
     * @return saved bowler stats.
     */
    Bowler saveBowlerStats(Bowler bowler);
}
