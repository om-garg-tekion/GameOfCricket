package com.CricketGame.GameOfCricket.service.psvm_service;

import com.CricketGame.GameOfCricket.model.entities.Player;
import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import com.CricketGame.GameOfCricket.model.interfaces.Factory;
import com.CricketGame.GameOfCricket.model.interfaces.TeamFactory;
import com.CricketGame.GameOfCricket.utils.Constants;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamCreation implements TeamFactory {

    private static final Faker instantiateFaker = FakerGenerator.getInstance();

    @Override
    public Team create(int noOfPlayers){

        int battingOrderNumber = Constants.START_OF_BATTING_ORDER_NUMBER;
        List<Player> players = new ArrayList<>();
        Factory playerFactory = new PlayerCreation();

        Team team = new Team(instantiateFaker.name().fullName());

        int temp = 0;

        for(int i=0; i<noOfPlayers; i++){
            Player player = (Player) playerFactory.create();
            player.setBattingOrderNumber(battingOrderNumber);
            if(temp < noOfPlayers/2){
                player.setPlayerRole(PlayerRole.BATSMAN);
            } else {
                player.setPlayerRole(PlayerRole.BOWLER);
            }
            players.add(player);
            temp++;
            battingOrderNumber++;
        }

        players.sort(Comparator.comparingInt(Player::getBattingOrderNumber));

        team.setPlayers(players);



        return team;
    }

}
