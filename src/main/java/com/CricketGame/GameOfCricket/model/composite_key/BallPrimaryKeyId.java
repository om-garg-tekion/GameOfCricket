package com.CricketGame.GameOfCricket.model.composite_key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BallPrimaryKeyId implements Serializable {
    private long id;
    private long inningId;
    private long matchId;
}
