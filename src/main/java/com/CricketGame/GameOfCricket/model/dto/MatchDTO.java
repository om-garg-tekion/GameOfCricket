package com.CricketGame.GameOfCricket.model.dto;

import com.CricketGame.GameOfCricket.model.beans.Team;
import lombok.Data;

@Data
public class MatchDTO {
    private Long id;
    private int numberOfPlayersInATeam;
    private int overs;
    private Long winnerTeamId;
    private int target;
    private Team firstTeam;
    private Team secondTeam;
}
