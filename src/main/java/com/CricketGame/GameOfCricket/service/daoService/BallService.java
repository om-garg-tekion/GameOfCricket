package com.CricketGame.GameOfCricket.service.daoService;

import com.CricketGame.GameOfCricket.model.beans.Ball;
import com.CricketGame.GameOfCricket.repository.BallRepository;
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
