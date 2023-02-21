package com.CricketGame.GameOfCricket.model.dto;

import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import lombok.Data;

@Data
public class PlayerDTO {
    private Long id;
    private Long teamId;
    private Long matchId;
    private Long batsmanStatsId;
    private Long bowlingStatsId;
    private String name;
    private int battingOrderNumber;
    private PlayerRole playerRole;

}
