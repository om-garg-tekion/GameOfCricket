package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.dto.MatchDTO;

import java.util.Optional;

public class MatchMapperUtilsTest {

    public Match getMatch(long id, Optional<Long> winningTeamId, int numberOfPlayersInATeam, int overs,
                          Optional<Integer> target){
        Match match = new Match();
        match.setId(id);
        match.setNumberOfPlayersInATeam(numberOfPlayersInATeam);
        match.setOvers(overs);
        match.setFirstTeam(new Team());
        match.setSecondTeam(new Team());
        if(winningTeamId.isPresent()) {
            match.setWinnerTeamId(winningTeamId.get());
        }
        if(target.isPresent()) {
            match.setTarget(target.get());
        }
        return match;
    }

    public MatchDTO getMatchDto(Long id, Long winningTeamId, int numberOfPlayersInATeam, int overs, int target){
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(id);
        matchDTO.setTarget(target);
        matchDTO.setOvers(overs);
        matchDTO.setWinnerTeamId(winningTeamId);
        matchDTO.setNumberOfPlayersInATeam(numberOfPlayersInATeam);
        matchDTO.setFirstTeam(new Team());
        matchDTO.setSecondTeam(new Team());
        return matchDTO;
    }
}
