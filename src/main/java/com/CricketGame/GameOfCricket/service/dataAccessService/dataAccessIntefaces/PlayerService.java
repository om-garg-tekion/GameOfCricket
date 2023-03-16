package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces;

import com.CricketGame.GameOfCricket.model.beans.player.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    /** This method will take a player entity and save it in the database
     * @param player The player that needs to be saved
     * @return returns player from the database.
     */
    public Player savePlayer(Player player);

    /** This method finds the required player from the database through its id
     * @param matchId the id of the match that is used to find player.
     * @param teamId the id of the team that is used to find team.
     * @param playerId, teamId and matchId plays the role of composite key of the player that needs to be found.
     * @return returns the required player from the database
     */
    public Optional<Player> findById(Long playerId, Long teamId, Long matchId);

    /** This method validates the required player from the database through its id.
     * @param matchId the id of the match that is used to find player.
     * @param teamId the id of the team that is used to find player.
     * @param playerId, teamId and matchId plays the role of composite key of the player that needs to be validated.
     * @return returns true if player with required id is present else returns false.
     */
    public boolean validatePlayer(Long playerId, Long teamId, Long matchId);

    /** This method finds the required player from the database through its name
     * @param name the name of the player that needs to be found
     * @return returns the required player from the database
     */
    public Optional<List<Player>> getPlayerByName(String name);

    /** This method finds the required player from the database through batting order number and teamId.
     * @param battingOrderNumber the batting order number of the player that needs to be found.
     * @param teamId the teamId in which player needs to be found.
     * @return returns the required player from the database
     */
    Optional<Player> getPlayerByBattingOrderNumber(int battingOrderNumber, long teamId);
}
