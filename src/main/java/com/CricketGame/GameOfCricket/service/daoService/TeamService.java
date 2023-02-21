package com.CricketGame.GameOfCricket.service.daoService;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.keys.PlayerKey;
import com.CricketGame.GameOfCricket.model.keys.TeamKey;
import com.CricketGame.GameOfCricket.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public boolean checkTeam(Long teamId, Long matchId) {
        Optional<Team> team = this.teamRepository.findById(new TeamKey(teamId, matchId));
        try{
            if(team.isEmpty()){
                throw new IllegalArgumentException("Error: Team with given id's is not present");
            }
        }catch(Exception e){
            e.printStackTrace();
            return true;
        }
        return false;
    }
}
