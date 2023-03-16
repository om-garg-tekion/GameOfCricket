package com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessServices;

import com.CricketGame.GameOfCricket.model.beans.Ball;
import com.CricketGame.GameOfCricket.repository.BallRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.BallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BallServiceImp implements BallService {
    @Autowired
    private BallRepository ballRepository;

    @Override
    public Ball saveBall(Ball ball){
        return this.ballRepository.save(ball);
    }
}
