package com.CricketGame.GameOfCricket.model.classes;

import lombok.Data;

import java.util.List;

@Data
public class Innings extends Bean{
    private Team BattingTeam;

    private Team BowlingTeam;

    private List<Over> overs;
}
