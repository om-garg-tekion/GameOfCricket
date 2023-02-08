package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Innings;
import com.CricketGame.GameOfCricket.model.classes.Match;
import com.CricketGame.GameOfCricket.model.classes.Player;
import com.CricketGame.GameOfCricket.model.classes.Team;
import lombok.Data;

@Data
public class PrintFinalResult {

    public static void printFinalResult(Match match){
        Team firstTeam = match.getFirstTeam();
        Team secondTeam = match.getSecondTeam();
        int numberOfWickets = match.getTeamSize();
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
