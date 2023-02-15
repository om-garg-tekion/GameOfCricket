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


    private int numberOfPlayersInATeam;


    private int overs;


    @Transient
    private Team winner;
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
    private Long firstTeamId;

    @Transient
    private Team secondTeam;
    private Long secondTeamId;
}
