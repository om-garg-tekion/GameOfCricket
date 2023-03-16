package com.CricketGame.GameOfCricket.service.factory;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamFactoryImp implements TeamFactory {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerFactory playerFactory;

    @Override
    public Team create(long teamId, long matchId, List<Player> players){

        List<Player> tempPlayerList = new ArrayList<>();

        for (Player player : players){
            tempPlayerList.add(playerFactory.create(player.getId(), teamId, matchId));
        }

        tempPlayerList.sort(Comparator.comparingInt(Player::getBattingOrderNumber));

        Team team = teamService.findById(teamId, matchId);

        team.setPlayers(tempPlayerList);

        return team;
    }

}
