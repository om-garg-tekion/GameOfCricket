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
@Table(name = "player",
       indexes = {@Index(name = "idx_player_name", columnList = "name"),
               @Index(name = "idx_player_role", columnList = "player_role"),
               @Index(name = "idx_batting_order_number", columnList = "batting_order_number")})
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

    @Column(name = "name")
    private String name;

    @Column(name = "batting_order_number")
    private int battingOrderNumber;

    @Transient
    private Batsman batsmanStats;

    @Transient
    private Bowler bowlerStats;

    @Enumerated(EnumType.STRING)
    @Column(name = "player_role")
    private Role playerRole;

}