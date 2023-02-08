package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Player;
import com.CricketGame.GameOfCricket.model.classes.Team;
import com.CricketGame.GameOfCricket.model.interfaces.Factory;
import com.CricketGame.GameOfCricket.model.interfaces.TeamFactory;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TeamMakingFactory implements TeamFactory {

    private static final Faker instantiateFaker = InstantiateFaker.getInstance();
    @Override
    public Team create(int noOfPlayers){

        int battingOrderNumber = 1;
        List<Player> players = new ArrayList<>();
        Factory playerFactory = new PlayerFactory();

        Team team = new Team(instantiateFaker.name().fullName());

        for(int i=0; i<noOfPlayers; i++){
            Player player = (Player) playerFactory.create();
            player.setBattingOrderNumber(battingOrderNumber);
            players.add(player);

            battingOrderNumber++;
        }

        players.sort(Comparator.comparingInt(Player::getBattingOrderNumber));

        team.setPlayers(players);

        return team;
    }

}
