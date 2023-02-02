package com.CricketGame.GameOfCricket;

import com.CricketGame.GameOfCricket.service.MatchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GameOfCricketApplication {

	public static void main(String[] args) {

		SpringApplication.run(GameOfCricketApplication.class, args);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Overs: ");
		int overs = sc.nextInt();// Asking User for Number of Overs.
		System.out.println("Enter Number of Players in a Team: ");
		int noOfPlayers = sc.nextInt();// Asking User for Number of Players in a Team.
		MatchService match = new MatchService(overs, noOfPlayers); // Initializing variables and making object of required class
		match.startMatch();// After initialization starting the game.
	}

}
