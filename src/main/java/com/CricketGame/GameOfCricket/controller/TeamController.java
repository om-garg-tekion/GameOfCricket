package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.dto.Response;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.dto.TeamDTO;
import com.CricketGame.GameOfCricket.service.mapper.TeamMapper;
import com.CricketGame.GameOfCricket.service.dataAccessService.TeamService;
import com.CricketGame.GameOfCricket.service.responseBuilder.ResponseBuilder;
import com.CricketGame.GameOfCricket.service.validator.TeamValidator;
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
    public Response addTeam(@RequestBody TeamDTO teamDTO) {
        Team team = TeamMapper.toTeam(teamDTO);
        if (TeamValidator.inputValidator(team)){
            return ResponseBuilder.responseBuilder(teamDTO, 403, "Invalid Inputs");
        }
        team.setId(teamService.saveTeam(team).getId());
        return ResponseBuilder.responseBuilder(TeamMapper.toTeamDto(team), 201, "Team Added");
    }

    @PostMapping("/teams")
    public Response addTeams(@RequestBody List<TeamDTO> teamDTOS) {
        List<TeamDTO> teams = new ArrayList<>();

        for(TeamDTO teamDTO : teamDTOS){
            Team team = TeamMapper.toTeam(teamDTO);

            if (TeamValidator.inputValidator(team)){
                return ResponseBuilder.responseBuilder(teamDTO, 403, "Invalid Inputs");
            }

            team.setId(teamService.saveTeam(team).getId());
            teams.add(TeamMapper.toTeamDto(team));
        }

        return ResponseBuilder.responseBuilder(teams, 201, "Teams Added");
    }
}
