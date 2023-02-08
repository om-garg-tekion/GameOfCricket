package com.CricketGame.GameOfCricket;

import com.CricketGame.GameOfCricket.service.InitiateGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GameOfCricketApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameOfCricketApplication.class, args);
		InitiateGame.initialGame();
	}

}
