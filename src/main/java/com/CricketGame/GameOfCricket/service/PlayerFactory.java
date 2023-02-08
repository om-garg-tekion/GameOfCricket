package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Batsman;
import com.CricketGame.GameOfCricket.model.classes.Bowler;
import com.CricketGame.GameOfCricket.model.classes.Player;
import com.CricketGame.GameOfCricket.model.interfaces.Factory;
import com.github.javafaker.Faker;


public class PlayerFactory implements Factory {

    private Faker faker = new Faker();

    @Override
    public Player create(){

        String name = faker.name().fullName();

        Player player = new Player();

        player.setName(name);
        player.setAsABatsman(new Batsman());
        player.setAsABowler(new Bowler());

        return player;
    }
}
