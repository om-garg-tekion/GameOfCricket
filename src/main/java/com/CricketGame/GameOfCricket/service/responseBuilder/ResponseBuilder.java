package com.CricketGame.GameOfCricket.service.responseBuilder;

import com.CricketGame.GameOfCricket.model.dto.Response;
import com.CricketGame.GameOfCricket.service.singletonInstantiator.ResponseInstantiator;

public class ResponseBuilder {
    public static Response responseBuilder(Object object, int statusCode, String message){
        Response response = ResponseInstantiator.getInstance();
        response.setObject(object);
        response.setStatusCode(statusCode);
        response.setMessage(message);
        return response;
    }

}
