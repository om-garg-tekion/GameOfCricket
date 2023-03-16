package com.CricketGame.GameOfCricket.service.starter.inningStarter;

import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.model.beans.Match;

public interface InningStarter {

    void play(Innings innings, boolean isFirstInnings, Match match);
}
