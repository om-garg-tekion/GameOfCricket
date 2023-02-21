package com.CricketGame.GameOfCricket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Object object;
    private int statusCode;
    private String message;
}
