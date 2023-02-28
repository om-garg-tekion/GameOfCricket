package com.CricketGame.GameOfCricket.model.beans.player;

import com.CricketGame.GameOfCricket.model.enums.Role;
import com.CricketGame.GameOfCricket.model.keys.PlayerKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(PlayerKey.class)
public class Player{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    private Long teamId;

    @Id
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
    private Role playerRole;

}