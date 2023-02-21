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
public class TeamPrimaryKeyId implements Serializable {
    private Long id;
    private Long matchId;
}
