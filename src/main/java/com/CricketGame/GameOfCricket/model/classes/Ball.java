package com.CricketGame.GameOfCricket.model.classes;

import com.CricketGame.GameOfCricket.model.enums.Runs;
import lombok.Data;

@Data
public class Ball extends Bean{
    private Runs runs;

    private Player playedBy;
}
