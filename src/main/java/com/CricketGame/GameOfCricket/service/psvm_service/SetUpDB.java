package com.CricketGame.GameOfCricket.service.psvm_service;

import com.CricketGame.GameOfCricket.model.entities.*;
import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import com.CricketGame.GameOfCricket.service.database_service.AllService;

public class SetUpDB {

    static Match match;

    static void init() {
        //        AllService.playerService.savePlayer(match.getFirstTeam().getPlayers().get(0));
        setUpPlayerEntity(match.getFirstTeam());
        setUpPlayerEntity(match.getSecondTeam());
        setUpTeamEntity(match.getFirstTeam());
        setUpTeamEntity(match.getSecondTeam());
        setUpMatchEntity();
        setUpIdsForMatchEntity();
        setUpIdsForTeamEntity(match.getFirstTeam());
        setUpIdsForTeamEntity(match.getSecondTeam());
        setIdsForPlayerEntity(match.getFirstTeam());
        setIdsForPlayerEntity(match.getSecondTeam());
        setUpBatsmanStats(match.getFirstTeam());
        setUpBatsmanStats(match.getSecondTeam());
        setUpBowlerStats(match.getFirstTeam());
        setUpBowlerStats(match.getSecondTeam());
        setUpInningsEntity(match.getFirstInnings(), true);
        setUpInningsEntity(match.getSecondInnings(), false);
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
        match.setWinnerTeamId(match.getWinner().getId());
        AllService.matchService.saveMatch(match);
    }

    static void setUpIdsForTeamEntity(Team team) {
        team.setMatchId(match.getId());
        AllService.teamService.saveTeam(team);
    }

    static void setIdsForPlayerEntity(Team team) {
        for (Player player : team.getPlayers()) {
            player.setTeamId(team.getId());
            player.setMatchId(match.getId());
            AllService.playerService.savePlayer(player);
        }
    }

    static void setUpInningsEntity(Innings innings, boolean isFirstInning){
        innings.setMatchId(match.getId());
        innings.setBattingTeamId(innings.getBattingTeam().getId());
        innings.setBowlingTeamId(innings.getBowlingTeam().getId());
        innings.setIsFirstInning(isFirstInning);
        AllService.inningsService.saveInnings(innings);
    }

    static void setUpBallEntity(Innings innings){
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
