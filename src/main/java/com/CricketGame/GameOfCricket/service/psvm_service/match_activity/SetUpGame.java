package com.CricketGame.GameOfCricket.service.psvm_service.match_activity;

import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.service.psvm_service.SetUpDB;
import com.CricketGame.GameOfCricket.service.psvm_service.singleton_instantiation.FakerGenerator;
import com.CricketGame.GameOfCricket.service.psvm_service.team_creation.TeamCreation;
import com.CricketGame.GameOfCricket.utils.Constants;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class SetUpGame {

    private static final Faker instantiateFaker = FakerGenerator.getInstance();

    public static void initialGame(){
        TeamCreation teamMakingFactory = new TeamCreation();
        int overs = Integer.parseInt(instantiateFaker.number().digits(2));// Asking User for Number of Overs.
//        int noOfPlayers = Integer.parseInt(instantiateFaker.number().digits(2));// Asking User for Number of Players in a Team.
//        int overs = 20;
        int noOfPlayers = Constants.NUMBER_OF_PLAYERS_IN_A_TEAM;
        Team firstTeam = teamMakingFactory.create(noOfPlayers);
        Team secondTeam = teamMakingFactory.create(noOfPlayers);
        BeginMatch beginMatch = new BeginMatch(overs, noOfPlayers, firstTeam, secondTeam); // Initializing
        // variables and making object of required class.
        SetUpDB.match = beginMatch.startMatch();
        SetUpDB.init();;
    }
}
