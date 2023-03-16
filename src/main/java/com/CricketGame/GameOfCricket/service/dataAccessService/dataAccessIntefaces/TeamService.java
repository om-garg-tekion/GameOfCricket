package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces;

import com.CricketGame.GameOfCricket.model.beans.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    /** This method will take a team entity and save it in the database
     * @param team The team that needs to be saved
     * @return returns team from the database.
     */
    Team saveTeam(Team team);

    /** This method finds the required team from the database through its id
     * @param matchId the id of the match that is used to find team.
     * @param teamId and matchId plays the role of composite key of the team that needs to be found.
     * @return returns the required team from the database
     */
    Team findById(Long teamId, Long matchId);

    /** This method validates the required team from the database through its id.
     * @param matchId the id of the match that is used to find team.
     * @param teamId and matchId plays the role of composite key of the team that needs to be validated.
     * @return returns true if team with required id is present else returns false.
     */
    boolean validateTeam(Long teamId, Long matchId);

    /** This method finds the required team from the database through its name
     * @param name the name of the team that needs to be found
     * @return returns the required team from the database
     */
    Optional<Team> getTeamByName(String name);
}
