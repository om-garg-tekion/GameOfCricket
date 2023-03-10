package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;

import java.util.*;

public class BattingOrderNumberValidatorUtilsTest {

    public List<Integer> getBattingOrderNumbers(){
        List<Integer> battingOrder = new ArrayList<>();
        battingOrder.add(1);
        battingOrder.add(2);
        battingOrder.add(3);
        return battingOrder;
    }

    public Team getTeam(){
        Team team = new Team();
        List<Player> players = new ArrayList<>();
        Player player = new Player();
        player.setBattingOrderNumber(1);
        players.add(player);
        player.setBattingOrderNumber(2);
        players.add(player);
        team.setPlayers(players);
        return team;
    }
}
