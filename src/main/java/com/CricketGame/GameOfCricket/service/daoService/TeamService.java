package com.CricketGame.GameOfCricket.service.daoService;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.keys.TeamKey;
import com.CricketGame.GameOfCricket.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team saveTeam(Team team) {
        return this.teamRepository.save(team);
    }

    public List<Team> saveTeams(List<Team> teams) {
        return this.teamRepository.saveAll(teams);
    }

    public Team findById(Long teamId, Long matchId) {
        return this.teamRepository.findById(new TeamKey(teamId, matchId)).orElse(null);
    }
}
