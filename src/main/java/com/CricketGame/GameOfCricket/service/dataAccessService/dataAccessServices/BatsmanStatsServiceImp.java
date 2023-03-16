package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessServices;

import com.CricketGame.GameOfCricket.model.beans.player.Batsman;
import com.CricketGame.GameOfCricket.repository.BatsmanRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.BatsmanStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatsmanStatsServiceImp implements BatsmanStatsService {

    @Autowired
    private BatsmanRepository batsmanRepository;

    @Override
    public Batsman saveBatsmanStats(Batsman batsman){
        return this.batsmanRepository.save(batsman);
    }
}
