package com.CricketGame.GameOfCricket.model.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match extends Bean{

    private int teamSize;

    private int overs;

    private int numberOfPlayersInATeam;

    private Team winner;

    private Innings firstInnings;

    private Innings secondInnings;

    private int target;

    private Team firstTeam;

    private Team secondTeam;
}
