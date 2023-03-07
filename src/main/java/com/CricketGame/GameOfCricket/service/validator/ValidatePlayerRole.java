package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;
import com.CricketGame.GameOfCricket.model.enums.Role;

import java.util.Arrays;
import java.util.List;

public class ValidatePlayerRole{
    public static boolean isValid(PlayerDTO player) {
        List<String> validatePlayerRoles = Arrays.asList(Role.BATSMAN.getDisplayValue().toLowerCase(),
                Role.BOWLER.getDisplayValue().toLowerCase());
        return validatePlayerRoles.contains(player.getPlayerRole().toLowerCase());
    }
}
