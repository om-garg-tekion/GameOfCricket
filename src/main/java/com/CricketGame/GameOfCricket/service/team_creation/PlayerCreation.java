package com.CricketGame.GameOfCricket.service.team_creation;

import com.CricketGame.GameOfCricket.model.entities.Player.Batsman;
import com.CricketGame.GameOfCricket.model.entities.Player.Bowler;
import com.CricketGame.GameOfCricket.model.entities.Player.Player;
import com.CricketGame.GameOfCricket.model.interfaces.Factory;
import com.CricketGame.GameOfCricket.service.dao_service.AllService;
import com.CricketGame.GameOfCricket.service.singleton_instantiation.FakerGenerator;
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

    public Player create(Long id){

        Player player = AllService.playerService.findById(id);
        player.setBatsmanStats(new Batsman());
        player.setBowlerStats(new Bowler());

        return player;
    }
}
