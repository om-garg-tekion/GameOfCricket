package com.CricketGame.GameOfCricket.model.beans.player;

import com.CricketGame.GameOfCricket.model.enums.Runs;
import com.CricketGame.GameOfCricket.service.runsSelector.RunsSelector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "batsman_stats")
public class Batsman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalRunsMade = 0;

    private int totalBallsPlayed = 0;

    private int numberOfFours = 0;

    private int numberOfSixes = 0;

    @Transient
    private Player outBy;

    private Long bowledBy;

    public Runs getRunsForBatsman() {
        return RunsSelector.getRandomRunsForBatsman();
    }

    public Runs getRunsForBowler() {
        return RunsSelector.getRandomRunsForBowler();
    }
}
