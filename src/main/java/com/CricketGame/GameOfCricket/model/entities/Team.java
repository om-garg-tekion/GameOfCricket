package com.CricketGame.GameOfCricket.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team extends Bean{
    private List<Player> players;

    private int totalRuns = 0;

    private int wickets = 0;

    private String name;

    public Team(String name){
        this.name = name;
    }

}
