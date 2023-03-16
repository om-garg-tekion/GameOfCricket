package com.CricketGame.GameOfCricket.service.factory.teamFactory;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;

import java.util.List;

public interface TeamFactory {

    Team create(long teamId, long matchId, List<Player> players);
}
