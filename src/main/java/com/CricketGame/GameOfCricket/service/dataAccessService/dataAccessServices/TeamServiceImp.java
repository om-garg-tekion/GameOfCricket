package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessServices;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.keys.TeamKey;
import com.CricketGame.GameOfCricket.repository.TeamRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImp implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team saveTeam(Team team) {
        return this.teamRepository.save(team);
    }

    @Override
    public Team findById(Long teamId, Long matchId) {
        return this.teamRepository.findById(new TeamKey(teamId, matchId)).orElse(null);
    }

    @Override
    public boolean validateTeam(Long teamId, Long matchId) {
        Optional<Team> team = this.teamRepository.findById(new TeamKey(teamId, matchId));
        try{
            if(team.isEmpty()){
                throw new IllegalArgumentException("Error: Team with given id's is not present");
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Optional<Team> getTeamByName(String name){
        return this.teamRepository.getTeamByName(name);
    }

}
