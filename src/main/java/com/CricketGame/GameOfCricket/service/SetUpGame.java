package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Team;
import com.github.javafaker.Faker;

public class SetUpGame {
    public static void initialGame(){
        Faker faker = new Faker();
        TeamCreation teamMakingFactory = new TeamCreation();
        int overs = Integer.parseInt(faker.number().digits(2));// Asking User for Number of Overs.
        int noOfPlayers = Integer.parseInt(faker.number().digits(2));;// Asking User for Number of Players in a Team.
        Team firstTeam = teamMakingFactory.create(noOfPlayers);
        Team secondTeam = teamMakingFactory.create(noOfPlayers);
        BeginMatch match = new BeginMatch(overs, noOfPlayers, firstTeam, secondTeam); // Initializing variables and making object of required class.
        match.startMatch();// After initialization starting the game.
    }
}
