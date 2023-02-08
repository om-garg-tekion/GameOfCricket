package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Innings;
import com.CricketGame.GameOfCricket.model.classes.Player;
import com.CricketGame.GameOfCricket.model.classes.Team;
import lombok.Data;

@Data
public class ScoreBoard {
    public static void printInningsResult(Innings innings){
        Team battingTeam  = innings.getBattingTeam();
        Team bowlingTeam = innings.getBowlingTeam();

        System.out.println("Batting Team: " + battingTeam.getName());
        System.out.println("Bowling Team: " + bowlingTeam.getName());

        System.out.println("Statistics of Batting Team: ");
        System.out.printf("-----------------------------------------------------------------------------------------%n");
        System.out.printf("| %25s | %5s | %5s | %5s | %5s | %25s |%n", "Name", "Runs", "Balls", "Fours", "Sixes", "Wicket Taken By");
        System.out.printf("-----------------------------------------------------------------------------------------%n");
        for(Player player : battingTeam.getPlayers()){
            System.out.printf("| %25s | %5s | %5s | %5s | %5s | %25s |%n", player.getName(), player.getAsABatsman().getTotalRunsMade(), player.getAsABatsman().getTotalBallsPlayed(), player.getAsABatsman().getNumberOfFours(), player.getAsABatsman().getNumberOfSixes(), player.getAsABatsman().getOutBy() == null ? "Not Out" : player.getAsABatsman().getOutBy().getName());
        }
        System.out.printf("-----------------------------------------------------------------------------------------%n");
        System.out.printf("| %25s | %5s | %5s | %5s | %5s | %25s |%n", "Total", battingTeam.getTotalRuns(), "", "", "", "");
        System.out.printf("-----------------------------------------------------------------------------------------%n%n");

        System.out.println("Statistics of Bowling Team: ");
        System.out.printf("-----------------------------------------------%n");
        System.out.printf("| %25s | %7s | %5s |%n", "Name", "Wickets", "Overs");
        System.out.printf("-----------------------------------------------%n");
        for(Player player : bowlingTeam.getPlayers()){
            System.out.printf("| %25s | %7s | %5s |%n", player.getName(), player.getAsABowler().getNumberOfWicketTaken(), player.getAsABowler().getNumberOfOverTaken());
        }
        System.out.printf("-----------------------------------------------%n");
        System.out.printf("| %25s | %7s | %5s |%n", "Total", battingTeam.getWickets(), "");
        System.out.printf("-----------------------------------------------%n%n");
    }

    public static void printFinalResult(Team firstTeam, Team secondTeam, int numberOfWickets){
        if(firstTeam.getTotalRuns() > secondTeam.getTotalRuns()){
            System.out.println(firstTeam.getName() + " won the match by " + (numberOfWickets - firstTeam.getWickets()) + " wickets.");
        } else if(firstTeam.getTotalRuns() < secondTeam.getTotalRuns()){
            System.out.println(secondTeam.getName() + " won the match by " + (numberOfWickets - secondTeam.getWickets()) + " wickets.");
        } else {
            System.out.println("It's a tie between both the teams");
        }
    }
}
