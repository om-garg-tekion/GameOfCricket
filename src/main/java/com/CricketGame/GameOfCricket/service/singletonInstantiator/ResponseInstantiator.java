package com.CricketGame.GameOfCricket.service.singletonInstantiator;

import com.CricketGame.GameOfCricket.model.dto.Response;

public class ResponseInstantiator extends Response {
    private static final ResponseInstantiator responseInstantiator = new ResponseInstantiator();

    private ResponseInstantiator(){}

    public static ResponseInstantiator getInstance(){
        return responseInstantiator;
    }
}
