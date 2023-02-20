package com.CricketGame.GameOfCricket.service.team_creation;

import com.CricketGame.GameOfCricket.model.entities.Player.Player;
import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import com.CricketGame.GameOfCricket.service.dao_service.AllService;
import com.CricketGame.GameOfCricket.service.singleton_instantiation.FakerGenerator;
import com.CricketGame.GameOfCricket.utils.Constants;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamCreation {

    public static Team create(Long id, List<Player> players){

        PlayerCreation playerCreation = new PlayerCreation();

        List<Player> tempPlayerList = new ArrayList<>();

        for (Player player : players){
            tempPlayerList.add(playerCreation.create(player.getId()));
        }

        tempPlayerList.sort(Comparator.comparingInt(Player::getBattingOrderNumber));

        Team team = AllService.teamService.findById(id);

        team.setPlayers(tempPlayerList);

        System.out.println(tempPlayerList);

        return team;
    }

}
