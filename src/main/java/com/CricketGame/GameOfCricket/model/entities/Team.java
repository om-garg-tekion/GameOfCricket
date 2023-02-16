package com.CricketGame.GameOfCricket.model.entities;

import com.CricketGame.GameOfCricket.model.entities.Player.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Team{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long matchId;

    @Transient
    private List<Player> players;

    private int totalRuns = 0;

    private int wickets = 0;

    private String name;

    public Team(String name){
        this.name = name;
    }

}
