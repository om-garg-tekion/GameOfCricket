package com.CricketGame.GameOfCricket.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDTO {
    private Long id;
    private Long matchId;
    private int totalRuns;
    private int wickets;
    private String name;

}
