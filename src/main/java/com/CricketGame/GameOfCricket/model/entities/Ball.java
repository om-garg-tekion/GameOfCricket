package com.CricketGame.GameOfCricket.model.entities;

import com.CricketGame.GameOfCricket.model.enums.Runs;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ball{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long inningId;

    private Long matchId;

    //playedBy
    private Long batsmanId;

    //bowledBy
    private Long bowlerId;

    @Enumerated(EnumType.STRING)
    private Runs runs;

    private int ballNumber;

    @Transient
    private Player playedBy;
}
