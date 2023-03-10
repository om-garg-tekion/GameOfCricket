package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class BowlerSelectorUtilsTest {

    public Team getTeam(){
        Team team = new Team();
        List<Player> players = new ArrayList<>();

        Player player = new Player();
        player.setPlayerRole(Role.BOWLER);
        players.add(player);
        players.add(player);

        team.setPlayers(players);
        return team;
    }

}
