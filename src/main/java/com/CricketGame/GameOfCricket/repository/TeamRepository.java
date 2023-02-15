package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
