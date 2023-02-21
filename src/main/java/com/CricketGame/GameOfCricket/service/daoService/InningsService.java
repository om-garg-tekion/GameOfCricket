package com.CricketGame.GameOfCricket.service.daoService;

import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.repository.InningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InningsService {
    @Autowired
    private InningsRepository inningsRepository;

    public Innings saveInnings(Innings innings){
        return this.inningsRepository.save(innings);
    }
}
