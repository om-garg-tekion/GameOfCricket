package com.CricketGame.GameOfCricket.service.mapper;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.dto.TeamDTO;

public class TeamMapper {
    public static Team toTeam(TeamDTO teamDTO){
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setMatchId(teamDTO.getMatchId());
        return team;
    }
    public static TeamDTO toTeamDto(Team team){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setWickets(team.getWickets());
        teamDTO.setTotalRuns(team.getTotalRuns());
        teamDTO.setMatchId(team.getMatchId());
        return teamDTO;
    }
}
