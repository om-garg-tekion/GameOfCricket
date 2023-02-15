package com.CricketGame.GameOfCricket.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "innings")
public class Innings{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Long matchId;

    @Transient
    private Team battingTeam;

//    private Long battingTeamId;

    @Transient
    private Team bowlingTeam;

//    private Long bowlingTeamId;
//
//    private Boolean isFirstInning;

    @Transient
    private List<Over> overs;
}
