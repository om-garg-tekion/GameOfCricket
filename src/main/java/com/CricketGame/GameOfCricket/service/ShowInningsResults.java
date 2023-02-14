package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Innings;
import com.CricketGame.GameOfCricket.model.classes.Player;
import com.CricketGame.GameOfCricket.model.classes.Team;
import com.CricketGame.GameOfCricket.model.enums.PlayerRole;

public class ShowInningsResults {
    public static void printInningsResult(Innings innings){
        Team battingTeam  = innings.getBattingTeam();
        Team bowlingTeam = innings.getBowlingTeam();

        System.out.println("Batting Team: " + battingTeam.getName());
        System.out.println("Bowling Team: " + bowlingTeam.getName());

        System.out.println("\nStatistics of Batting Team: ");
        System.out.printf("---------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-25s | %-7s | %-5s | %-5s | %-5s | %-5s | %-25s |%n", "Name", "Role", "Runs", "Balls", "Fours", "Sixes", "Wicket Taken By");
        System.out.printf("---------------------------------------------------------------------------------------------------%n");
        for(Player player : battingTeam.getPlayers()){
            System.out.printf("| %-25s | %-7s | %-5s | %-5s | %-5s | %-5s | %-25s |%n", player.getName(), player.getPlayerRole().getPlayerRole(), player.getAsABatsman().getTotalRunsMade(), player.getAsABatsman().getTotalBallsPlayed(), player.getAsABatsman().getNumberOfFours(), player.getAsABatsman().getNumberOfSixes(), player.getAsABatsman().getOutBy() == null ? player.getAsABatsman().getTotalBallsPlayed() != 0 ? "Not Out" : "Not Played" : player.getAsABatsman().getOutBy().getName());
        }
        System.out.printf("---------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-25s | %-7s | %-5s | %-5s | %-5s | %-5s | %-25s |%n", "Total", battingTeam.getTotalRuns(),"","", "", "", "");
        System.out.printf("---------------------------------------------------------------------------------------------------%n%n");

        System.out.println("Statistics of Bowling Team: ");
        System.out.printf("-----------------------------------------------%n");
        System.out.printf("| %-25s | %-7s | %-5s |%n", "Name", "Wickets", "Overs");
        System.out.printf("-----------------------------------------------%n");
        for(Player player : bowlingTeam.getPlayers()){
            if(PlayerRole.BOWLER.equals(player.getPlayerRole())){
                System.out.printf("| %-25s | %-7s | %-5s |%n", player.getName(), player.getAsABowler().getNumberOfWicketTaken(), player.getAsABowler().getNumberOfOverTaken());
            }
        }
        System.out.printf("-----------------------------------------------%n");
        System.out.printf("| %-25s | %-7s | %-5s |%n", "Total", battingTeam.getWickets(), innings.getOvers().size());
        System.out.printf("-----------------------------------------------%n%n");
    }
}
