package com.CricketGame.GameOfCricket.utils;


import com.CricketGame.GameOfCricket.model.Over;
import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.model.beans.player.Bowler;
import com.CricketGame.GameOfCricket.model.beans.player.Player;

import java.util.ArrayList;
import java.util.List;

public class InningsResultUtilsTest {

//    private static String getNumberOfOverTaken(Player player) {
//        int totalBalls = player.getBowlerStats().getNumberOfBallsTaken();
//        int over = totalBalls / Constants.BALLS_IN_A_OVER;
//        int ballsLeft = totalBalls % Constants.BALLS_IN_A_OVER;
//        return (over + "." + ballsLeft);
//    }
//
//    private static String getTotalNumberOfOverPlayed(Innings innings) {
//        int overSize = innings.getOvers().size();
//        int sizeOfLastOver = innings.getOvers().get(overSize - 1).getBalls().size();
//        if (Constants.BALLS_IN_A_OVER != sizeOfLastOver) { // Constant in left
//            return overSize - 1 + "." + sizeOfLastOver;
//        }
//        return overSize + ".0";
//    }

    public Player getPlayer(){
        Player player = new Player();
        Bowler bowler = new Bowler();
        bowler.setNumberOfBallsTaken(20);
        player.setBowlerStats(bowler);
        return player;
    }

    public Innings getInnings(){
        Innings innings = new Innings();
        List<Over> overs = new ArrayList<>();
        Over over = new Over();
        over.setBalls(new ArrayList<>(6));
        overs.add(over);
        overs.add(over);
        overs.add(over);
        overs.add(over);
        overs.add(over);
        over.setBalls(new ArrayList<>(3));
        overs.add(over);
        innings.setOvers(overs);
        return innings;
    }
}
