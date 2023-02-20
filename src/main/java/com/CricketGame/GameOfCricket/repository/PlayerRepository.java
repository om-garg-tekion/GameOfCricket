package com.CricketGame.GameOfCricket.repository;

import com.CricketGame.GameOfCricket.model.composite_key.PlayerPrimaryKeyId;
import com.CricketGame.GameOfCricket.model.entities.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, PlayerPrimaryKeyId> {

}
