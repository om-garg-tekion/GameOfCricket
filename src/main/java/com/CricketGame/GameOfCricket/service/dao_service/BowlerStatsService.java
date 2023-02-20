package com.CricketGame.GameOfCricket.service.dao_service;

import com.CricketGame.GameOfCricket.model.entities.Player.Bowler;
import com.CricketGame.GameOfCricket.repository.BowlerRepository;
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
