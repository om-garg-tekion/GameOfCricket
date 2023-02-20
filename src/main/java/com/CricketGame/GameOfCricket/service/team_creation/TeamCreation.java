package com.CricketGame.GameOfCricket.service.team_creation;

import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.model.entities.player.Player;
import com.CricketGame.GameOfCricket.service.dao_service.AllService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamCreation{
    public static Team create(long teamId, long matchId, List<Player> players){

        List<Player> tempPlayerList = new ArrayList<>();

        for (Player player : players){
            tempPlayerList.add(PlayerCreation.create(player.getId(), teamId, matchId));
        }

        tempPlayerList.sort(Comparator.comparingInt(Player::getBattingOrderNumber));

        Team team = AllService.teamService.findById(teamId, matchId);

        team.setPlayers(tempPlayerList);

        System.out.println(tempPlayerList);

        return team;
    }

}
