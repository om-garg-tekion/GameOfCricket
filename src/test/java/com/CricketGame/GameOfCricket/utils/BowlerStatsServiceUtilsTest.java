package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.player.Bowler;

public class BowlerStatsServiceUtilsTest {

    public Bowler getBowler(Long id){
        Bowler bowler = new Bowler();
        bowler.setId(id);
        return bowler;
    }

}
