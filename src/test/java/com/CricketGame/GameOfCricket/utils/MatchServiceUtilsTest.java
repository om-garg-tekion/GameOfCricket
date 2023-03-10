package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.Match;

import java.util.Optional;

public class MatchServiceUtilsTest {

    public Match getMatch(Long matchId){
        Match match = new Match();
        match.setId(matchId);
        return match;
    }

    public Optional<Match> getNullMatch(){
        return Optional.empty();
    }
}
