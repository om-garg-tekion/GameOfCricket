package com.CricketGame.GameOfCricket.model.entities.player;

import com.CricketGame.GameOfCricket.model.composite_key.PlayerPrimaryKeyId;
import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(PlayerPrimaryKeyId.class)
public class Player{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Id
    private long teamId;

    @Id
    private long matchId;

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