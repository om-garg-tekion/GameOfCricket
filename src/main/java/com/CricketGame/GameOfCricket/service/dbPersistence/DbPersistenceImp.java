package com.CricketGame.GameOfCricket.service.dbPersistence;

import com.CricketGame.GameOfCricket.model.Over;
import com.CricketGame.GameOfCricket.model.beans.Ball;
import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.enums.Role;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DbPersistenceImp implements DbPersistence {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private MatchService matchService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private BatsmanStatsService batsmanStatsService;

    @Autowired
    private BowlerStatsService bowlerStatsService;

    @Autowired
    private InningsService inningsService;

    @Autowired
    private BallService ballService;

    @Override
    public void init(Match match) {
        setUpPlayerEntity(match.getFirstTeam());
        setUpPlayerEntity(match.getSecondTeam());
        setUpTeamEntity(match.getFirstTeam());
        setUpTeamEntity(match.getSecondTeam());
        setUpMatchEntity(match);
        setUpIdsForMatchEntity(match);
        setUpBatsmanStats(match.getFirstTeam());
        setUpBatsmanStats(match.getSecondTeam());
        setUpBowlerStats(match.getFirstTeam());
        setUpBowlerStats(match.getSecondTeam());
        match.setFirstInnings(setUpInningsEntity(match, match.getFirstInnings(), true));
        match.setSecondInnings(setUpInningsEntity(match, match.getSecondInnings(), false));
        setUpBallEntity(match, match.getFirstInnings());
        setUpBallEntity(match, match.getSecondInnings());
    }

    @Override
    public void setUpMatchEntity(Match match) {
        matchService.saveMatch(match);
    }

    @Override
    public void setUpPlayerEntity(Team team) {
        for (Player player : team.getPlayers()) {
            playerService.savePlayer(player);
        }
    }

    @Override
    public void setUpTeamEntity(Team team) {
        teamService.saveTeam(team);
    }

    @Override
    public void setUpBatsmanStats(Team team) {
        for(Player player : team.getPlayers()){
            if(player.getBatsmanStats().getOutBy() != null) {
                player.getBatsmanStats().setBowledBy(player.getBatsmanStats().getOutBy().getId());
            }
            player.setBatsmanStatsId(batsmanStatsService.saveBatsmanStats(player.getBatsmanStats()).getId());
            playerService.savePlayer(player);
        }
    }

    @Override
    public void setUpBowlerStats(Team team){
        for(Player player : team.getPlayers()){
            if(Role.BOWLER.equals(player.getPlayerRole())) {
                player.setBowlingStatsId(bowlerStatsService.saveBowlerStats(player.getBowlerStats()).getId());
                playerService.savePlayer(player);
            }
        }
    }

    @Override
    public void setUpIdsForMatchEntity(Match match) {
        if (match.getWinner() != null) {
            match.setWinnerTeamId(match.getWinner().getId());
        }
        matchService.saveMatch(match);
    }

    @Override
    public Innings setUpInningsEntity(Match match, Innings innings, boolean isFirstInning){
        innings.setMatchId(match.getId());
        innings.setBattingTeamId(innings.getBattingTeam().getId());
        innings.setBowlingTeamId(innings.getBowlingTeam().getId());
        innings.setIsFirstInning(isFirstInning);
        innings.setId(inningsService.saveInnings(innings).getId());
        return innings;
    }

    @Override
    public void setUpBallEntity(Match match, Innings innings){
        System.out.println(innings.getId());
        for(Over over : innings.getOvers()){
            for(Ball ball : over.getBalls()){
                ball.setMatchId(match.getId());
                ball.setInningId(innings.getId());
                ball.setBatsmanId(ball.getPlayedBy().getId());
                ball.setBowlerId(over.getBowler().getId());
                ballService.saveBall(ball);
            }
        }
    }
}
