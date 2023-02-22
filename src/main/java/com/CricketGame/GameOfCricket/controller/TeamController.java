package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.Response;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.dto.TeamDTO;
import com.CricketGame.GameOfCricket.model.dtoMapper.TeamMapper;
import com.CricketGame.GameOfCricket.service.daoService.TeamService;
import com.CricketGame.GameOfCricket.service.inputChecker.TeamInputChecker;
import com.CricketGame.GameOfCricket.service.singletonInstantiator.ResponseInstantiator;
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
        Response response = ResponseInstantiator.getInstance();
        if (TeamInputChecker.checkInputs(team)){
            response.setObject(teamDTO);
            response.setStatusCode(500);
            response.setMessage("Invalid Inputs");
            return response;
        }
        team.setId(teamService.saveTeam(team).getId());
        response.setObject(TeamMapper.toDto(team));
        response.setStatusCode(200);
        response.setMessage("Team Added");
        return response;
    }

    @PostMapping("/teams")
    public Response addTeams(@RequestBody List<TeamDTO> teamDTOS) {
        List<TeamDTO> teams = new ArrayList<>();
        Response response = ResponseInstantiator.getInstance();
        for(TeamDTO teamDTO : teamDTOS){
            Team team = TeamMapper.toTeam(teamDTO);
            if (TeamInputChecker.checkInputs(team)){
                response.setObject(teamDTO);
                response.setStatusCode(403);
                response.setMessage("Invalid Inputs");
                return response;
            }
            team.setId(teamService.saveTeam(team).getId());
            teams.add(TeamMapper.toDto(team));
        }
        response.setObject(teams);
        response.setStatusCode(201);
        response.setMessage("Teams Added");
        return response;
    }
}
