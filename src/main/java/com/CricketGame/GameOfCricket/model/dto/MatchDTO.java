package com.CricketGame.GameOfCricket.model.dto;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchDTO {
    private Long id;
    private int numberOfPlayersInATeam;
    private int overs;
    private Long winnerTeamId;
    private int target;
    private Team firstTeam;
    private Team secondTeam;
}
