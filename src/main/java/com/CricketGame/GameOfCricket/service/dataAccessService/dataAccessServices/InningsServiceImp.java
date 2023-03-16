package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessServices;

import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.repository.InningsRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.InningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InningsServiceImp implements InningsService {
    @Autowired
    private InningsRepository inningsRepository;

    @Override
    public Innings saveInnings(Innings innings){
        return this.inningsRepository.save(innings);
    }
}
