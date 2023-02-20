package com.CricketGame.GameOfCricket.model.entities.player;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bowler_stats")
public class Bowler{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfWicketTaken;

//    private int numberOfOverTaken;

    private int numberOfBallsTaken;
}
