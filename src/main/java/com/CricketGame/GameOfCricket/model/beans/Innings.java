package com.CricketGame.GameOfCricket.model.beans;

import com.CricketGame.GameOfCricket.model.Over;
import com.CricketGame.GameOfCricket.model.keys.InningKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "innings")
@IdClass(InningKey.class)
public class Innings{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    private Long matchId;

    @Transient
    private Team battingTeam;

    @Column(name = "batting_team")
    private Long battingTeamId;

    @Transient
    private Team bowlingTeam;

    @Column(name = "bowling_team")
    private Long bowlingTeamId;

    private Boolean isFirstInning;

    @Transient
    private List<Over> overs;
}
