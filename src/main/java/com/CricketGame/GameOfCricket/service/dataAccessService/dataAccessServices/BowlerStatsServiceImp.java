package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessServices;

import com.CricketGame.GameOfCricket.model.beans.player.Bowler;
import com.CricketGame.GameOfCricket.repository.BowlerRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.BowlerStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BowlerStatsServiceImp implements BowlerStatsService {
    @Autowired
    private BowlerRepository bowlerRepository;

    @Override
    public Bowler saveBowlerStats(Bowler bowler){
        return this.bowlerRepository.save(bowler);
    }
}
