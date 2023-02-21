package com.CricketGame.GameOfCricket.service.daoService;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService{

    @Autowired
    private MatchRepository matchRepository;

    public Match saveMatch(Match match){
        return this.matchRepository.save(match);
    }

    public Match findById(Long id) {
        return this.matchRepository.findById(id).orElse(null);
    }

    public boolean checkMatch(Long matchId) {
        Optional<Match> match = this.matchRepository.findById(matchId);
        try{
            if(match.isEmpty()){
                throw new IllegalArgumentException("Error: Match with given this id is not present");
            } else if (match.get().getWinnerTeamId() != null && match.get().getTarget() != 0) {
                throw new IllegalArgumentException("Error: Match with given this id is already played");
            }
        }catch(Exception e){
            e.printStackTrace();
            return true;
        }
        return false;
    }
}
