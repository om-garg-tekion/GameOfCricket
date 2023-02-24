package com.CricketGame.GameOfCricket.model.enums;

import lombok.Getter;

@Getter
public enum Role {
    BATSMAN("Batsman"),
    BOWLER("Bowler");

    private final String displayValue;
    Role(String role){
        displayValue = role;
    }
}
