package com.CricketGame.GameOfCricket.service.psvm_service;

import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.repository.MatchRepository;
import com.CricketGame.GameOfCricket.repository.PlayerRepository;
import com.CricketGame.GameOfCricket.repository.TeamRepository;
import com.CricketGame.GameOfCricket.utils.Constants;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetUpGame {

    @Autowired
    private static TeamRepository teamRepository;

    @Autowired
    private static PlayerRepository playerRepository;

    @Autowired
    private static MatchRepository matchRepository;


    public SetUpGame(TeamRepository teamRepository, PlayerRepository playerRepository, MatchRepository matchRepository) {
        SetUpGame.teamRepository = teamRepository;
        SetUpGame.playerRepository = playerRepository;
        SetUpGame.matchRepository = matchRepository;
    }


    public static void initialGame(){
        Faker faker = new Faker();
        TeamCreation teamMakingFactory = new TeamCreation(playerRepository, teamRepository);
        int overs = Integer.parseInt(faker.number().digits(2));// Asking User for Number of Overs.
//        int noOfPlayers = Integer.parseInt(faker.number().digits(2));// Asking User for Number of Players in a Team.
//        int overs = 20;
        int noOfPlayers = Constants.NUMBER_OF_PLAYERS_IN_A_TEAM;
        Team firstTeam = teamMakingFactory.create(noOfPlayers);
        Team secondTeam = teamMakingFactory.create(noOfPlayers);
        BeginMatch match = new BeginMatch(overs, noOfPlayers, firstTeam, secondTeam, matchRepository); // Initializing
        // variables and making object of required class.
        match.startMatch();// After initialization starting the game.
    }
}
