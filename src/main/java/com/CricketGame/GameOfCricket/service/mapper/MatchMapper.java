package com.CricketGame.GameOfCricket.service.mapper;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.dto.MatchDTO;

public class MatchMapper {
    public static Match toMatch(MatchDTO matchDTO){
        Match match = new Match();
        match.setId(matchDTO.getId());
        match.setNumberOfPlayersInATeam(matchDTO.getNumberOfPlayersInATeam());
        match.setOvers(matchDTO.getOvers());
        match.setFirstTeam(matchDTO.getFirstTeam());
        match.setSecondTeam(matchDTO.getSecondTeam());
        return match;
    }
    public static MatchDTO toMatchDto(Match match){
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(match.getId());
        matchDTO.setTarget(match.getTarget());
        matchDTO.setOvers(match.getOvers());
        matchDTO.setWinnerTeamId(match.getWinnerTeamId());
        matchDTO.setNumberOfPlayersInATeam(match.getNumberOfPlayersInATeam());
        matchDTO.setFirstTeam(match.getFirstTeam());
        matchDTO.setSecondTeam(match.getSecondTeam());
        return matchDTO;
    }
}
