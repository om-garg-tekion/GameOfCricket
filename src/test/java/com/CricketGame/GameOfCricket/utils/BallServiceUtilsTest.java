package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.Ball;

import java.util.Optional;

public class BallServiceUtilsTest {

    public Optional<Ball> getNullOptionalBall()
    {
        return Optional.empty();
    }

    public Ball getBall(){
        return new Ball();
    }

}
