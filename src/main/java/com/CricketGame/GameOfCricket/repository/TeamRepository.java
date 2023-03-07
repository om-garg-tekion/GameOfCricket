package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.keys.TeamKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, TeamKey> {

    @Query("SELECT t FROM Team t WHERE t.name =:n")
    public Optional<Team> getTeamByName(@Param("n") String name);

    @Query("SELECT t FROM Team t WHERE t.matchId =:matchId ")
    public Optional<List<Team>> getTeamByMatchId(@Param("matchId") long matchId);
}
