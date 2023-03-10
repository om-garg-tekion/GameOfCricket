package com.CricketGame.GameOfCricket.service.dataAccessService;

import com.CricketGame.GameOfCricket.model.beans.Ball;
import com.CricketGame.GameOfCricket.repository.BallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BallService {
    @Autowired
    private BallRepository ballRepository;

    public Ball saveBall(Ball ball){
        return this.ballRepository.save(ball);
    }
}
