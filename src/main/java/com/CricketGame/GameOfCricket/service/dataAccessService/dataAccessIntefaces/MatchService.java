package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces;

import com.CricketGame.GameOfCricket.model.beans.Match;

import java.util.Optional;

public interface MatchService {

    /** This method finds the required match from the database through its id
     * @param id the id of the match that needs to be found
     * @return returns the required match from the database with all other data like team data, player data and their
     * stats.
     */
    public Optional<Match> getScoreBoardByMatchId(long id);

    /** This method finds the required match from the database through winning team id
     * @param id the id of the team that is used to find match
     * @return returns the required match from the database
     */
    public Optional<Match> getMatchByWinnerId(long id);

    /** This method validates the required match from the database through its id
     * @param matchId the id of the match that needs to be validated
     * @return returns true if match with required id is present else returns false
     */
    public boolean validateMatch(Long matchId);

    /** This method finds the required match from the database through its id
     * @param id the id of the match that needs to be found
     * @return returns the required match from the database
     */
    public Match findById(Long id);

    /** This method will take a match entity and save it in the database
     * @param match The match that needs to be saved
     * @return returns match from the database.
     */
    public Match saveMatch(Match match);


}
