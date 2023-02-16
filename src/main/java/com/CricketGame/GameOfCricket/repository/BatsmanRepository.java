package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.entities.Batsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatsmanRepository extends JpaRepository<Batsman, Long> {

}
