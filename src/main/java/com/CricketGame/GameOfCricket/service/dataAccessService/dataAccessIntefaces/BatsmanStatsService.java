package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces;

import com.CricketGame.GameOfCricket.model.beans.player.Batsman;

public interface BatsmanStatsService {

    /** Saving batsman stats.
     * @param batsman stats that need to be saved.
     * @return saved batsman stats.
     */
    Batsman saveBatsmanStats(Batsman batsman);
}
