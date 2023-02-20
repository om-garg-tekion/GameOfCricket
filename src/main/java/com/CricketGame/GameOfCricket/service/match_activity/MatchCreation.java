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
        Match existingMatch = AllService.matchService.findById(match.getId());

        match.setNumberOfPlayersInATeam(existingMatch.getNumberOfPlayersInATeam());
        match.setOvers(existingMatch.getOvers());

        Team exisitingFirstTeam = AllService.teamService.findById(match.getFirstTeam().getId(), match.getId());

        Team exisitingSecondTeam = AllService.teamService.findById(match.getSecondTeam().getId(), match.getId());

        Team firstTeam = match.getFirstTeam();
        Team secondTeam = match.getSecondTeam();


        assert firstTeam != null;
        match.setFirstTeam(TeamCreation.create(firstTeam.getId(), match.getId(), firstTeam.getPlayers()));

        assert secondTeam != null;
        match.setSecondTeam(TeamCreation.create(secondTeam.getId(), match.getId(), secondTeam.getPlayers()));

        match.getFirstTeam().setName(exisitingFirstTeam.getName());
        match.getSecondTeam().setName(exisitingSecondTeam.getName());

        System.out.println(match);

        return SetUpGame.initialGame(match);
    }
}
