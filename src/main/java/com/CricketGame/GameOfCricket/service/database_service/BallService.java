package com.CricketGame.GameOfCricket.service.database_service;

import com.CricketGame.GameOfCricket.model.entities.Ball;
import com.CricketGame.GameOfCricket.model.entities.Batsman;
import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.repository.BallRepository;
import com.CricketGame.GameOfCricket.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BallService {
    @Autowired
    private BallRepository ballRepository;

    public void saveBall(Ball ball){
        this.ballRepository.save(ball);
    }
}
