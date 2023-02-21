package com.CricketGame.GameOfCricket.service.daoService;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class AllService {

    public static PlayerService playerService;

    public static MatchService matchService;

    public static TeamService teamService;

    public static BatsmanStatsService batsmanStatsService;

    public static BowlerStatsService bowlerStatsService;

    public static InningsService inningsService;

    public static BallService ballService;

    @Autowired
    public AllService(PlayerService playerService, MatchService matchService, TeamService teamService,
                      BatsmanStatsService batsmanStatsService, BowlerStatsService bowlerStatsService,
                      InningsService inningsService, BallService ballService) {
        this.playerService = playerService;
        this.matchService = matchService;
        this.teamService = teamService;
        this.batsmanStatsService = batsmanStatsService;
        this.bowlerStatsService = bowlerStatsService;
        this.inningsService = inningsService;
        this.ballService = ballService;
    }
}
