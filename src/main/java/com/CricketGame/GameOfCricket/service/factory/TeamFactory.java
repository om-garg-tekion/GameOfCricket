package com.CricketGame.GameOfCricket.service.factory;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.service.dataAccessService.AllService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamFactory {
    public static Team create(long teamId, long matchId, List<Player> players){

        List<Player> tempPlayerList = new ArrayList<>();

        for (Player player : players){
            tempPlayerList.add(PlayerFactory.create(player.getId(), teamId, matchId));
        }

        tempPlayerList.sort(Comparator.comparingInt(Player::getBattingOrderNumber));

        Team team = AllService.teamService.findById(teamId, matchId);

        team.setPlayers(tempPlayerList);

        System.out.println(tempPlayerList);

        return team;
    }

}
