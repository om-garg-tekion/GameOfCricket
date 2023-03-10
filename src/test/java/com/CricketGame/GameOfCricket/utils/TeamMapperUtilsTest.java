package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.dto.TeamDTO;

import java.util.OptionalInt;
import java.util.OptionalLong;

public class TeamMapperUtilsTest {

    public Team getTeam(OptionalLong id, long matchId, String name, OptionalInt wickets, OptionalInt totalRuns){
        Team team = new Team();
        team.setName(name);
        team.setMatchId(matchId);
        if(id.isPresent()){
            team.setId(id.getAsLong());
        }
        if(wickets.isPresent()){
            team.setWickets(wickets.getAsInt());
        }
        if(totalRuns.isPresent()){
            team.setTotalRuns(totalRuns.getAsInt());
        }
        return team;
    }

    public TeamDTO getTeamDto(long id, long matchId, String name, int wickets, int totalRuns){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(id);
        teamDTO.setName(name);
        teamDTO.setWickets(wickets);
        teamDTO.setTotalRuns(totalRuns);
        teamDTO.setMatchId(matchId);
        return teamDTO;
    }

}
