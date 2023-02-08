package com.CricketGame.GameOfCricket;

import com.CricketGame.GameOfCricket.model.classes.Team;
import com.CricketGame.GameOfCricket.service.MatchService;
import com.CricketGame.GameOfCricket.service.TeamMakingFactory;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GameOfCricketApplication {



	public static void main(String[] args) {
		Faker faker = new Faker();
		SpringApplication.run(GameOfCricketApplication.class, args);
		TeamMakingFactory teamMakingFactory = new TeamMakingFactory();
		int overs = Integer.parseInt(faker.number().digits(2));// Asking User for Number of Overs.
		int noOfPlayers = Integer.parseInt(faker.number().digits(2));;// Asking User for Number of Players in a Team.
		Team firstTeam = teamMakingFactory.create(noOfPlayers);
		Team secondTeam = teamMakingFactory.create(noOfPlayers);
		MatchService match = new MatchService(overs, noOfPlayers, firstTeam, secondTeam); // Initializing variables and making object of required class.
		match.startMatch();// After initialization starting the game.
	}

}
