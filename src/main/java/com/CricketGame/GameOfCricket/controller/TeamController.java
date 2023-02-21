package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.dto.TeamDTO;
import com.CricketGame.GameOfCricket.model.dtoMapper.TeamMapper;
import com.CricketGame.GameOfCricket.service.daoService.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/team")
    public TeamDTO addTeam(@RequestBody TeamDTO teamDTO) {
        Team team = TeamMapper.toTeam(teamDTO);
        team.setId(teamService.saveTeam(team).getId());
        return TeamMapper.toDto(team);
    }

    @PostMapping("/teams")
    public List<TeamDTO> addTeams(@RequestBody List<TeamDTO> teamDTOS) {
        List<TeamDTO> teams = new ArrayList<>();
        for(TeamDTO teamDTO : teamDTOS){
            Team team = TeamMapper.toTeam(teamDTO);
            team.setId(teamService.saveTeam(team).getId());
            teams.add(TeamMapper.toDto(team));
        }
        return teams;
    }
}
