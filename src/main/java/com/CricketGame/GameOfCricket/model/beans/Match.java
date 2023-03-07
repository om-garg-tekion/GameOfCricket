package com.CricketGame.GameOfCricket.model.beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`match`",
       indexes = {@Index(name = "idx_winner_team_id", columnList = "winner_team")})
public class Match{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_strength")
    private int numberOfPlayersInATeam;

    private int overs;

    @Transient
    private Team winner;

    @Column(name = "winner_team")
    private Long winnerTeamId;

    @Transient
    private Innings firstInnings;

    @Transient
    private Innings secondInnings;

    private int target;

    @Transient
    private Team firstTeam;

    @Transient
    private Team secondTeam;
}
