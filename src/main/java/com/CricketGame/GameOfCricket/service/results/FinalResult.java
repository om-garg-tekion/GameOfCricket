package com.CricketGame.GameOfCricket.service.results;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;

public class FinalResult {

    public static void printFinalResult(Match match){
        Team firstTeam = match.getFirstTeam();
        Team secondTeam = match.getSecondTeam();
        int numberOfWickets = match.getNumberOfPlayersInATeam();
        if(firstTeam.getTotalRuns() > secondTeam.getTotalRuns()){
            System.out.println(firstTeam.getName() + " won the match by " + (numberOfWickets - firstTeam.getWickets()) + " wickets.");
            match.setWinner(firstTeam);
        } else if(firstTeam.getTotalRuns() < secondTeam.getTotalRuns()){
            System.out.println(secondTeam.getName() + " won the match by " + (numberOfWickets - secondTeam.getWickets()) + " wickets.");
            match.setWinner(secondTeam);
        } else {
            System.out.println("It's a tie between both the teams");
        }
    }
}
