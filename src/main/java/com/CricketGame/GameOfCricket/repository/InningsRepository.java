package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.entities.Innings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InningsRepository extends JpaRepository<Innings, Long> {
}
