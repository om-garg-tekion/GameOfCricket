package com.CricketGame.GameOfCricket.model.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BallKey implements Serializable {
    private Long id;
    private Long inningId;
    private Long matchId;
}
