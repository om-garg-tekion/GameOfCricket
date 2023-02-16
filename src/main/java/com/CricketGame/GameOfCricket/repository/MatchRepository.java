package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {

}