package com.CricketGame.GameOfCricket.service.database_service;

import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public void saveTeam(Team team){
        this.teamRepository.save(team);
    }
}
