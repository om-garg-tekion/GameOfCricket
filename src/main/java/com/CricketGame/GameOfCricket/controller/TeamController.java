package com.CricketGame.GameOfCricket.controller;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.dto.TeamDTO;
import com.CricketGame.GameOfCricket.service.dataAccessService.TeamService;
import com.CricketGame.GameOfCricket.service.mapper.TeamMapper;
import com.CricketGame.GameOfCricket.service.validator.TeamValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/team")
    public ResponseEntity<TeamDTO> addTeam(@RequestBody TeamDTO teamDTO) {
        Team team = TeamMapper.toTeam(teamDTO);
        if (TeamValidator.inputValidator(team)){
            return ResponseEntity.notFound().build();
        }
        team.setId(teamService.saveTeam(team).getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(TeamMapper.toTeamDto(team));
    }

    @PostMapping("/teams")
    public ResponseEntity<List<TeamDTO>> addTeams(@RequestBody List<TeamDTO> teamDTOS) {
        List<TeamDTO> teams = new ArrayList<>();

        for(TeamDTO teamDTO : teamDTOS){
            Team team = TeamMapper.toTeam(teamDTO);

            if (TeamValidator.inputValidator(team)){
                return ResponseEntity.notFound().build();
            }

            team.setId(teamService.saveTeam(team).getId());
            teams.add(TeamMapper.toTeamDto(team));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(teams);
    }

    @GetMapping("/team/{name}")
    public ResponseEntity<TeamDTO> getTeamByName(@PathVariable("name") String name){
        Optional<Team> team = teamService.getTeamByName(name);
        return team.map(value -> ResponseEntity.ok(TeamMapper.toTeamDto(value)))
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
