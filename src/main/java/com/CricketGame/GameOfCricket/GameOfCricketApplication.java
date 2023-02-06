package com.CricketGame.GameOfCricket;

import com.CricketGame.GameOfCricket.model.classes.Batsman;
import com.CricketGame.GameOfCricket.model.classes.Bowler;
import com.CricketGame.GameOfCricket.model.classes.Player;
import com.CricketGame.GameOfCricket.service.MatchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class GameOfCricketApplication {

	public static List<Player> getTeam(int noOfPlayers){
		Scanner sc = new Scanner(System.in);
		List<Player> players = new ArrayList<>();
		for(int i=0; i<noOfPlayers; i++){
			System.out.println("Enter the details of Player " + (i+1) + ": ");
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Batting order: ");
			int order = sc.nextInt();
			Player player = new Player();
			player.setName(name);
			player.setOrderNumber(order);
			player.setAsABatsman(new Batsman());
			player.setAsABowler(new Bowler());
			players.add(player);
		}
		players.sort(Comparator.comparingInt(Player::getOrderNumber));
		return players;
	}
	public static void main(String[] args) {
		SpringApplication.run(GameOfCricketApplication.class, args);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Overs: ");
		int overs = sc.nextInt();// Asking User for Number of Overs.
		System.out.println("Enter Number of Players in a Team: ");
		int noOfPlayers = sc.nextInt();// Asking User for Number of Players in a Team.
		System.out.println("Now, enter the details for Team India");
		List<Player> firstTeamPlayers = getTeam(noOfPlayers);
		System.out.println("Now, enter the details of Team Pakistan");
		List<Player> secondTeamPlayers = getTeam(noOfPlayers);
		MatchService match = new MatchService(overs, noOfPlayers, firstTeamPlayers, secondTeamPlayers); // Initializing variables and making object of required class.
		match.startMatch();// After initialization starting the game.
	}

}
