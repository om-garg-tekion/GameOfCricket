package com.CricketGame.GameOfCricket.service.gameStarter;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.service.daoService.AllService;
import com.CricketGame.GameOfCricket.service.teamCreator.TeamCreator;
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
        match.setFirstTeam(TeamCreator.create(firstTeam.getId(), match.getId(), firstTeam.getPlayers()));

        assert secondTeam != null;
        match.setSecondTeam(TeamCreator.create(secondTeam.getId(), match.getId(), secondTeam.getPlayers()));

        match.getFirstTeam().setName(exisitingFirstTeam.getName());
        match.getSecondTeam().setName(exisitingSecondTeam.getName());

        System.out.println(match);

        return GameInitializer.initialGame(match);
    }
}
