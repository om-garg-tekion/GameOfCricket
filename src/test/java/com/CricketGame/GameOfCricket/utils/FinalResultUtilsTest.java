package com.CricketGame.GameOfCricket.utils;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;

public class FinalResultUtilsTest {

    public Match getMatch(String team1Name, int totalRunsOfTeam1, String team2Name, int totalRunsOfTeam2, int player){
        Match match = new Match();
        match.setNumberOfPlayersInATeam(player);

        Team team1 = new Team();
        team1.setName(team1Name);
        team1.setTotalRuns(totalRunsOfTeam1);
        match.setFirstTeam(team1);

        Team team2 = new Team();
        team2.setName(team2Name);
        team2.setTotalRuns(totalRunsOfTeam2);
        match.setSecondTeam(team2);

        return match;
    }

}
