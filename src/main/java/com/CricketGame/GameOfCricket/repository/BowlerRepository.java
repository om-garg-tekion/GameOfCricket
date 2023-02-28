package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.beans.player.Bowler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BowlerRepository extends JpaRepository<Bowler, Long> {

}
