package com.CricketGame.GameOfCricket.service.database_service;

import com.CricketGame.GameOfCricket.model.entities.Bowler;
import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.repository.BowlerRepository;
import com.CricketGame.GameOfCricket.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BowlerStatsService {
    @Autowired
    private BowlerRepository bowlerRepository;

    public Bowler saveBowlerStats(Bowler bowler){
        return this.bowlerRepository.save(bowler);
    }
}
