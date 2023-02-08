package com.CricketGame.GameOfCricket;

import com.CricketGame.GameOfCricket.model.classes.Batsman;
import com.CricketGame.GameOfCricket.model.classes.Bowler;
import com.CricketGame.GameOfCricket.model.classes.Player;
import com.CricketGame.GameOfCricket.model.classes.Team;
import com.CricketGame.GameOfCricket.model.interfaces.Factory;
import com.CricketGame.GameOfCricket.service.MatchService;
import com.CricketGame.GameOfCricket.service.PlayerFactory;
import com.CricketGame.GameOfCricket.service.TeamMakingFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class GameOfCricketApplication {
	public static void main(String[] args) {
		SpringApplication.run(GameOfCricketApplication.class, args);
		Scanner sc = new Scanner(System.in);
		TeamMakingFactory teamMakingFactory = new TeamMakingFactory();
		System.out.println("Enter Number of Overs: ");
		int overs = sc.nextInt();// Asking User for Number of Overs.
		System.out.println("Enter Number of Players in a Team: ");
		int noOfPlayers = sc.nextInt();// Asking User for Number of Players in a Team.
		System.out.println("Now, enter the details of first team");
		Team firstTeam = teamMakingFactory.create(noOfPlayers);
		System.out.println("Now, enter the details of second team");
		Team secondTeam = teamMakingFactory.create(noOfPlayers);
		MatchService match = new MatchService(overs, noOfPlayers, firstTeam, secondTeam); // Initializing variables and making object of required class.
		match.startMatch();// After initialization starting the game.
	}

}
