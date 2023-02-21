package com.CricketGame.GameOfCricket.model.dtoMapper;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.dto.TeamDTO;

public class TeamMapper {
    public static Team toTeam(TeamDTO teamDTO){
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setMatchId(teamDTO.getMatchId());
        return team;
    }
    public static TeamDTO toDto(Team team){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(teamDTO.getName());
        teamDTO.setWickets(teamDTO.getWickets());
        teamDTO.setTotalRuns(teamDTO.getTotalRuns());
        teamDTO.setMatchId(team.getMatchId());
        return teamDTO;
    }
}
