package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.entities.Ball;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BallRepository extends JpaRepository<Ball, Long> {

}
