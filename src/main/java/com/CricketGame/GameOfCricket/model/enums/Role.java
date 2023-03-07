package com.CricketGame.GameOfCricket.model.enums;

import lombok.Getter;

@Getter
public enum Role {
    BATSMAN("BATSMAN"),
    BOWLER("BOWLER");

    private final String displayValue;
    Role(String role){
        displayValue = role;
    }
}
