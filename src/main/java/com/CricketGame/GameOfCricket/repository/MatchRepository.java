package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.beans.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {

    @Query("SELECT m FROM `Match` m WHERE m.winnerTeamId =:id")
    public Optional<Match> getMatchByWinnerId(@Param("id") long id);
}
