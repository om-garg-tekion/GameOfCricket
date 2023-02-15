package com.CricketGame.GameOfCricket.model.entities;

import com.CricketGame.GameOfCricket.model.enums.Runs;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
public class Ball{

//    @Enumerated(EnumType.STRING)
    private Runs runs;

//    @Transient
    private Player playedBy;
}
