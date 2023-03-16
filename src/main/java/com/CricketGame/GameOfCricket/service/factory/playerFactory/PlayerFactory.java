package com.CricketGame.GameOfCricket.service.factory.playerFactory;

import com.CricketGame.GameOfCricket.model.beans.player.Player;

public interface PlayerFactory {

    Player create(long playerId, long teamId, long matchId);
}
