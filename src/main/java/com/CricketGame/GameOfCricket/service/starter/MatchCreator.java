package com.CricketGame.GameOfCricket.service.starter;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.service.dataAccessService.AllService;
import com.CricketGame.GameOfCricket.service.factory.TeamFactory;
import org.springframework.stereotype.Service;

@Service
public class MatchCreator {

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
        match.setFirstTeam(TeamFactory.create(firstTeam.getId(), match.getId(), firstTeam.getPlayers()));

        assert secondTeam != null;
        match.setSecondTeam(TeamFactory.create(secondTeam.getId(), match.getId(), secondTeam.getPlayers()));

        match.getFirstTeam().setName(exisitingFirstTeam.getName());
        match.getSecondTeam().setName(exisitingSecondTeam.getName());

        System.out.println(match);

        return GameStarter.startGame(match);
    }
}
