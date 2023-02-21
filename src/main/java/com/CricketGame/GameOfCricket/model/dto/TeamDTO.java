package com.CricketGame.GameOfCricket.model.dto;

import lombok.Data;

@Data
public class TeamDTO {
    private Long id;
    private Long matchId;
    private int totalRuns;
    private int wickets;
    private String name;

}
