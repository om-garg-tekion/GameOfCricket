package com.CricketGame.GameOfCricket.service.match_activity;

import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.service.dao_service.AllService;
import com.CricketGame.GameOfCricket.service.team_creation.TeamCreation;
import org.springframework.stereotype.Service;

@Service
public class MatchCreation {

    public static Match start(Match match){
        System.out.println(match);
        Team exisitingFirstTeam = AllService.teamService.findById(match.getFirstTeam().getId());

        Team exisitingSecondTeam = AllService.teamService.findById(match.getSecondTeam().getId());

        Team firstTeam = match.getFirstTeam();
        Team secondTeam = match.getSecondTeam();


        assert firstTeam != null;
        match.setFirstTeam(TeamCreation.create(firstTeam.getId(), firstTeam.getPlayers()));

        assert secondTeam != null;
        match.setSecondTeam(TeamCreation.create(secondTeam.getId(), secondTeam.getPlayers()));

        match.getFirstTeam().setName(exisitingFirstTeam.getName());
        match.getSecondTeam().setName(exisitingSecondTeam.getName());

        System.out.println(match);

        SetUpGame.initialGame(match);

        return match;
    }
}
