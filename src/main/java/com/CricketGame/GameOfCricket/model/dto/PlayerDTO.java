package com.CricketGame.GameOfCricket.model.dto;

import com.CricketGame.GameOfCricket.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDTO {
    private Long id;
    private Long teamId;
    private Long matchId;
    private Long batsmanStatsId;
    private Long bowlingStatsId;
    private String name;
    private int battingOrderNumber;
    private Role playerRole;

}
