package com.CricketGame.GameOfCricket.model.entities;

import com.CricketGame.GameOfCricket.model.composite_key.InningsPrimaryKeyId;
import com.CricketGame.GameOfCricket.model.entities.over.Over;
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
@IdClass(InningsPrimaryKeyId.class)
public class Innings{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Id
    private long matchId;

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
