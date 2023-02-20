package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.service.dao_service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/team")
    public Team addTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }

    @PostMapping("/teams")
    public List<Team> addTeams(@RequestBody List<Team> teams){
        return teamService.saveTeams(teams);
    }
}
