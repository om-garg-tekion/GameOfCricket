package com.CricketGame.GameOfCricket.model.enums;

import lombok.Getter;

@Getter
public enum PlayerRole {
    BATSMAN("Batsman"),
    BOWLER("Bowler");

    private final String playerRole;
    PlayerRole(String role){
        playerRole = role;
    }
}
