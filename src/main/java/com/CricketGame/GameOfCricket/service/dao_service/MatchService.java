package com.CricketGame.GameOfCricket.service.dao_service;

import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
