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
public class PlayerPrimaryKeyId implements Serializable {
    private long id;
    private long teamId;
    private long matchId;
}
