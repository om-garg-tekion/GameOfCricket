package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.Ball;
import com.CricketGame.GameOfCricket.model.beans.player.Batsman;

public class BatsmanStatsServiceUtilsTest {

    public Batsman getBatsman(Long id){
        Batsman batsman = new Batsman();
        batsman.setId(id);
        return batsman;
    }

}
