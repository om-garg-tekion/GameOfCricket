package com.CricketGame.GameOfCricket.model.classes;

import lombok.Data;

@Data
public class Player{
    private String name;

    private  int battingOrderNumber;

    private Batsman asABatsman;

    private Bowler asABowler;

}