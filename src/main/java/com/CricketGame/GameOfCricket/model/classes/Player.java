package com.CricketGame.GameOfCricket.model.classes;

import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import lombok.Data;

@Data
public class Player extends Bean{
    private String name;

    private  int battingOrderNumber;

    private Batsman asABatsman;

    private Bowler asABowler;

    private PlayerRole playerRole;

}