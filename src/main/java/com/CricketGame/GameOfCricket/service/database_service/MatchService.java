package com.CricketGame.GameOfCricket.service.database_service;

import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.model.entities.Player;
import com.CricketGame.GameOfCricket.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService{

    @Autowired
    private MatchRepository matchRepository;

    public void saveMatch(Match match){
        this.matchRepository.save(match);
    }
}
