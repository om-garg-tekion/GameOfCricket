package com.CricketGame.GameOfCricket.model.classes;

import com.CricketGame.GameOfCricket.model.enums.Runs;
import com.CricketGame.GameOfCricket.service.RunsSelection;
import lombok.Data;

@Data
public class Batsman{
    private int totalRunsMade = 0;

    private int totalBallsPlayed = 0;

    private int numberOfFours = 0;

    private int numberOfSixes = 0;

    private Player outBy;

    public Runs getRunsForBatsman(){
        return RunsSelection.getRandomRunsForBatsman();
    }

    public Runs getRunsForBowler(){
        return RunsSelection.getRandomRunsForBatsman();
    }
}
