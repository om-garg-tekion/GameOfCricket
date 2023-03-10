package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.keys.PlayerKey;
import com.CricketGame.GameOfCricket.model.keys.TeamKey;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class TeamServiceUtilsTest {

    public Team getTeam(TeamKey teamKey){
        Team team = new Team();
        team.setId(teamKey.getId());
        team.setMatchId(teamKey.getMatchId());
        return team;
    }

    public Optional<Team> getNullTeam(){
        return Optional.empty();
    }
}
