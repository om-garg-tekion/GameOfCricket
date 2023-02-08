package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Player;
import com.CricketGame.GameOfCricket.model.classes.Team;
import com.CricketGame.GameOfCricket.model.interfaces.Factory;
import com.CricketGame.GameOfCricket.model.interfaces.TeamFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeamMakingFactory implements TeamFactory {

    @Override
    public Team create(int noOfPlayers){

        Scanner sc = new Scanner(System.in);

        List<Player> players = new ArrayList<>();
        Factory playerFactory = new PlayerFactory();
        System.out.println("Enter the name of team: ");

        Team team = new Team(sc.next());

        for(int i=0; i<noOfPlayers; i++){
            System.out.println("Enter the details of Player " + (i+1) + ": ");
            players.add((Player) playerFactory.create());
        }

        players.sort(Comparator.comparingInt(Player::getBattingOrderNumber));

        team.setPlayers(players);

        return team;
    }

}
