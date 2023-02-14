package com.CricketGame.GameOfCricket.model.entities;

import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import lombok.Data;

@Data
public class Player extends Bean{
    private String name;

    private  int battingOrderNumber;

    private Batsman batsmanStats;

    private Bowler bowlerStats;

    private PlayerRole playerRole;

}