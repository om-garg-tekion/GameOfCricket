package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.beans.Ball;
import com.CricketGame.GameOfCricket.model.keys.BallKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BallRepository extends JpaRepository<Ball, BallKey> {

}
