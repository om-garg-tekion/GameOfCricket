package com.CricketGame.GameOfCricket.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`match`")
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

//    private Long firstInningsId;

    @Transient
    private Innings secondInnings;
//    private Long secondInningsId;

    private int target;

    @Transient
    private Team firstTeam;

//    @Column(name = "first_team")
//    private Long firstTeamId;

    @Transient
    private Team secondTeam;

//    @Column(name = "second_team")
//    private Long secondTeamId;
}
