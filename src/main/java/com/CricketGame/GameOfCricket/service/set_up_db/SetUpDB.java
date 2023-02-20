package com.CricketGame.GameOfCricket.service.set_up_db;

import com.CricketGame.GameOfCricket.model.entities.Innings;
import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.model.entities.over.Ball;
import com.CricketGame.GameOfCricket.model.entities.over.Over;
import com.CricketGame.GameOfCricket.model.entities.player.Player;
import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import com.CricketGame.GameOfCricket.service.dao_service.AllService;

public class SetUpDB {

    public static Match match;

    public static void init() {
        setUpPlayerEntity(match.getFirstTeam());
        setUpPlayerEntity(match.getSecondTeam());
        setUpTeamEntity(match.getFirstTeam());
        setUpTeamEntity(match.getSecondTeam());
        setUpMatchEntity();
        setUpIdsForMatchEntity();
        setUpBatsmanStats(match.getFirstTeam());
        setUpBatsmanStats(match.getSecondTeam());
        setUpBowlerStats(match.getFirstTeam());
        setUpBowlerStats(match.getSecondTeam());
        match.setFirstInnings(setUpInningsEntity(match.getFirstInnings(), true));
        match.setSecondInnings(setUpInningsEntity(match.getSecondInnings(), false));
        setUpBallEntity(match.getFirstInnings());
        setUpBallEntity(match.getSecondInnings());
    }

    static void setUpMatchEntity() {
        AllService.matchService.saveMatch(match);
    }

    static void setUpPlayerEntity(Team team) {
        for (Player player : team.getPlayers()) {
            AllService.playerService.savePlayer(player);
        }
    }

    static void setUpTeamEntity(Team team) {
        AllService.teamService.saveTeam(team);
    }

    static void setUpBatsmanStats(Team team) {
        for(Player player : team.getPlayers()){
            if(player.getBatsmanStats().getOutBy() != null) {
                player.getBatsmanStats().setBowledBy(player.getBatsmanStats().getOutBy().getId());
            }
            player.setBatsmanStatsId(AllService.batsmanStatsService.saveBatsmanStats(player.getBatsmanStats()).getId());
            AllService.playerService.savePlayer(player);
        }
    }

    static void setUpBowlerStats(Team team){
        for(Player player : team.getPlayers()){
            if(PlayerRole.BOWLER.equals(player.getPlayerRole())) {
                player.setBowlingStatsId(AllService.bowlerStatsService.saveBowlerStats(player.getBowlerStats()).getId());
                AllService.playerService.savePlayer(player);
            }
        }
    }

    static void setUpIdsForMatchEntity() {
        if (match.getWinner() != null) {
            match.setWinnerTeamId(match.getWinner().getId());
        }
        AllService.matchService.saveMatch(match);
    }

    static Innings setUpInningsEntity(Innings innings, boolean isFirstInning){
        innings.setMatchId(match.getId());
        innings.setBattingTeamId(innings.getBattingTeam().getId());
        innings.setBowlingTeamId(innings.getBowlingTeam().getId());
        innings.setIsFirstInning(isFirstInning);
        innings.setId(AllService.inningsService.saveInnings(innings).getId());
        return innings;
    }

    static void setUpBallEntity(Innings innings){
        System.out.println(innings.getId());
        for(Over over : innings.getOvers()){
            for(Ball ball : over.getBalls()){
                ball.setMatchId(match.getId());
                ball.setInningId(innings.getId());
                ball.setBatsmanId(ball.getPlayedBy().getId());
                ball.setBowlerId(over.getBowler().getId());
                AllService.ballService.saveBall(ball);
            }
        }
    }
}
