package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces;

import com.CricketGame.GameOfCricket.model.beans.Match;

import java.util.Optional;

public interface MatchService {

    public Optional<Match> getScoreBoardByMatchId(long id);
    public Optional<Match> getMatchByWinnerId(long id);
    public boolean validateMatch(Long matchId);
    public Match findById(Long id);
    public Match saveMatch(Match match);


}
