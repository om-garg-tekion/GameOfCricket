package com.CricketGame.GameOfCricket.service.starter.matchStarter;

import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;

public interface MatchStarter {

    Match matchInit(Match match);

    // Method for starting the cricket game
    void startMatch(Match match, Innings firstInnings, Innings secondInnings, Team firstTeam, Team secondTeam);

    void playInning(String x, Innings firstInnings, boolean isFirstInnings, Match match);
}
