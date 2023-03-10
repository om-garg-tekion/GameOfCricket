package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.Innings;

public class InningsServiceUtilsTest {

    public Innings getInnings(Long id, Long matchId){
        Innings innings = new Innings();
        innings.setId(id);
        innings.setMatchId(matchId);
        return innings;
    }

}
