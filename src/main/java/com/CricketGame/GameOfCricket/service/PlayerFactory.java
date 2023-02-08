package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Batsman;
import com.CricketGame.GameOfCricket.model.classes.Bowler;
import com.CricketGame.GameOfCricket.model.classes.Player;
import com.CricketGame.GameOfCricket.model.interfaces.Factory;

import java.util.Scanner;

public class PlayerFactory implements Factory {
    @Override
    public Player create(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Name: ");
        String name = sc.next();

        System.out.println("Batting order: ");
        int order = sc.nextInt();

        Player player = new Player();

        player.setName(name);
        player.setBattingOrderNumber(order);
        player.setAsABatsman(new Batsman());
        player.setAsABowler(new Bowler());

        return player;
    }
}
