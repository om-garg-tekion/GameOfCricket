package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces;

import com.CricketGame.GameOfCricket.model.beans.Ball;

public interface BallService {

    /** Saving ball stats.
     * @param ball stats that need to be saved.
     * @return saved ball stats.
     */
    public Ball saveBall(Ball ball);
}
