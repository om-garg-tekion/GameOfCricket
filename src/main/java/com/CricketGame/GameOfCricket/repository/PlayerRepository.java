package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.keys.PlayerKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, PlayerKey> {

    @Query("SELECT p FROM Player p")
    public List<Player> getAllPlayers();

//    @Query(nativeQuery = true, value = "EXPLAIN SELECT * FROM Player WHERE name =:n")
//    public List<?> getPlayerByName(@Param("n") String name);


    @Query("SELECT p FROM Player p WHERE p.name =:n")
    public Optional<List<Player>> getPlayerByName(@Param("n") String name);

    @Query("SELECT p FROM Player p WHERE p.battingOrderNumber =:battingOrderNumber AND p.teamId =:teamId")
    public Optional<Player> getPlayerByBattingOrderNumber(@Param("battingOrderNumber") int battingOrderNumber,
                                                         @Param("teamId") long teamId);

//    @Query(nativeQuery = true, value = "EXPLAIN SELECT p FROM Player p WHERE p.playerRole =:playerRole")
//    public List<?> getPlayerByRole(@Param("playerRole") Role playerRole);

}
