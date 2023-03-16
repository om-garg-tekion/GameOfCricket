package com.CricketGame.GameOfCricket.service.validator.playerValidator;

import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;

public interface PlayerValidator {

    boolean inputValidator(PlayerDTO player);
}
