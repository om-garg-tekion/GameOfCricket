package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.model.keys.InningKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InningsRepository extends JpaRepository<Innings, InningKey> {
}
