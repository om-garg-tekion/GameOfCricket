package com.CricketGame.GameOfCricket.service.validator;

import com.CricketGame.GameOfCricket.model.dto.PlayerDTO;

public interface PlayerValidator {

    boolean inputValidator(PlayerDTO player);
}
