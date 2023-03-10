package com.CricketGame.GameOfCricket.service.dataAccessService;

import com.CricketGame.GameOfCricket.model.beans.player.Batsman;
import com.CricketGame.GameOfCricket.repository.BatsmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatsmanStatsService {

    @Autowired
    private BatsmanRepository batsmanRepository;

    public Batsman saveBatsmanStats(Batsman batsman){
        return this.batsmanRepository.save(batsman);
    }
}
