package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces;

import com.CricketGame.GameOfCricket.model.beans.player.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    public Player savePlayer(Player player);
    public Optional<Player> findById(Long playerId, Long teamId, Long matchId);
    public boolean validatePlayer(Long playerId, Long teamId, Long matchId);
    public Optional<List<Player>> getPlayerByName(String name);

    Optional<Player> getPlayerByBattingOrderNumber(int battingOrderNumber, long teamId);

    public Optional<List<Player>> getPlayerByMatchIdAndTeamId(long matchId, long teamId);

}
