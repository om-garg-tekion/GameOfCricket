package com.CricketGame.GameOfCricket.service.database_service;

import com.CricketGame.GameOfCricket.model.entities.Innings;
import com.CricketGame.GameOfCricket.repository.InningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InningsService {
    @Autowired
    private InningsRepository inningsRepository;

    public void saveInnings(Innings innings){
        this.inningsRepository.save(innings);
    }
}
