package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces;

import com.CricketGame.GameOfCricket.model.beans.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    Team saveTeam(Team team);

    Team findById(Long teamId, Long matchId);

    boolean validateTeam(Long teamId, Long matchId);

    Optional<Team> getTeamByName(String name);

    Optional<List<Team>> getTeamByMatchId(long matchId);
}
