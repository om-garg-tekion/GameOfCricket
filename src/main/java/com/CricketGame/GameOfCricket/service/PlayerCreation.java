package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.entities.Batsman;
import com.CricketGame.GameOfCricket.model.entities.Bowler;
import com.CricketGame.GameOfCricket.model.entities.Player;
import com.CricketGame.GameOfCricket.model.interfaces.Factory;
import com.github.javafaker.Faker;


public class PlayerCreation implements Factory {

    private static final Faker instantiateFaker = FakerGenerator.getInstance();

    @Override
    public Player create(){

        String name = instantiateFaker.name().fullName();

        Player player = new Player();

        player.setName(name);
        player.setBatsmanStats(new Batsman());
        player.setBowlerStats(new Bowler());

        return player;
    }
}
