package com.CricketGame.GameOfCricket.model.entities.Player;

import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long teamId;

    private Long matchId;

    private Long batsmanStatsId;

    private Long bowlingStatsId;

    private String name;

    private int battingOrderNumber;

    @Transient
    private Batsman batsmanStats;

    @Transient
    private Bowler bowlerStats;

    @Enumerated(EnumType.STRING)
    private PlayerRole playerRole;

}