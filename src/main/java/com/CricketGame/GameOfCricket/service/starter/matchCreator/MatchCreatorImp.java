package com.CricketGame.GameOfCricket.service.starter.matchCreator;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.MatchService;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.TeamService;
import com.CricketGame.GameOfCricket.service.factory.teamFactory.TeamFactory;
import com.CricketGame.GameOfCricket.service.starter.gameStarter.GameStarter;
import com.CricketGame.GameOfCricket.service.validator.BattingOrderNumberValidator;
import com.CricketGame.GameOfCricket.service.validator.MinimumBowlersRequirementValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchCreatorImp implements MatchCreator {

    @Autowired
    private GameStarter gameStarter;

    @Autowired
    private MatchService matchService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamFactory teamFactory;

    @Override
    public Match start(Match match){
        Match existingMatch = matchService.findById(match.getId());

        match.setNumberOfPlayersInATeam(existingMatch.getNumberOfPlayersInATeam());
        match.setOvers(existingMatch.getOvers());

        Team exisitingFirstTeam = teamService.findById(match.getFirstTeam().getId(), match.getId());

        Team exisitingSecondTeam = teamService.findById(match.getSecondTeam().getId(), match.getId());

        Team firstTeam = match.getFirstTeam();
        Team secondTeam = match.getSecondTeam();

        assert firstTeam != null;
        match.setFirstTeam(teamFactory.create(firstTeam.getId(), match.getId(), firstTeam.getPlayers()));

        assert secondTeam != null;
        match.setSecondTeam(teamFactory.create(secondTeam.getId(), match.getId(), secondTeam.getPlayers()));

        match.getFirstTeam().setName(exisitingFirstTeam.getName());
        match.getSecondTeam().setName(exisitingSecondTeam.getName());

        if(match.getNumberOfPlayersInATeam() != match.getFirstTeam().getPlayers().size() || match.getNumberOfPlayersInATeam() != match.getSecondTeam().getPlayers().size()){
            return null;
        }

        if(MinimumBowlersRequirementValidator.isValid(match.getFirstTeam()) ||
           MinimumBowlersRequirementValidator.isValid(match.getSecondTeam())){
            return null;
        }

        if(!BattingOrderNumberValidator.isValid(match.getFirstTeam())){
            return null;
        }

        if(!BattingOrderNumberValidator.isValid(match.getSecondTeam())){
            return null;
        }

        return gameStarter.startGame(match);
    }
}
