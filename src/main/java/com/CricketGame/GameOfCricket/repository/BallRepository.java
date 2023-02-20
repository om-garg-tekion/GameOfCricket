package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.composite_key.BallPrimaryKeyId;
import com.CricketGame.GameOfCricket.model.entities.over.Ball;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BallRepository extends JpaRepository<Ball, BallPrimaryKeyId> {

}
