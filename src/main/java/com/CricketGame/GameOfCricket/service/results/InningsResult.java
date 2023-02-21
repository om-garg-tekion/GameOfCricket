package com.CricketGame.GameOfCricket.service.results;

import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.enums.PlayerRole;

public class InningsResult {
    private static String getNumberOfOverTaken(Player player){
        int totalBalls = player.getBowlerStats().getNumberOfBallsTaken();
        int over = totalBalls / 6;
        int ballsLeft = totalBalls % 6;
        return (over + "." + ballsLeft);
    }

    private static String getTotalNumberOfOverPlayed(Innings innings){
        int overSize = innings.getOvers().size();
        int sizeOfLastOver = innings.getOvers().get(overSize-1).getBalls().size();
        if(sizeOfLastOver != 6) {
            return overSize - 1 + "." + sizeOfLastOver;
        }
        return overSize + ".0";
    }
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
            System.out.printf("| %-25s | %-7s | %-5s | %-5s | %-5s | %-5s | %-25s |%n", player.getName(), player.getPlayerRole().getPlayerRole(), player.getBatsmanStats().getTotalRunsMade(), player.getBatsmanStats().getTotalBallsPlayed(), player.getBatsmanStats().getNumberOfFours(), player.getBatsmanStats().getNumberOfSixes(), player.getBatsmanStats().getOutBy() == null ? player.getBatsmanStats().getTotalBallsPlayed() != 0 ? "Not Out" : "Not Played" : player.getBatsmanStats().getOutBy().getName());
        }
        System.out.printf("---------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-25s | %-7s | %-5s | %-5s | %-5s | %-5s | %-25s |%n", "Total","",battingTeam.getTotalRuns(),"", "", "", "");
        System.out.printf("---------------------------------------------------------------------------------------------------%n%n");

        System.out.println("Statistics of Bowling Team: ");
        System.out.printf("-----------------------------------------------%n");
        System.out.printf("| %-25s | %-7s | %-5s |%n", "Name", "Wickets", "Overs");
        System.out.printf("-----------------------------------------------%n");
        for(Player player : bowlingTeam.getPlayers()){
            if(PlayerRole.BOWLER.equals(player.getPlayerRole())){
                System.out.printf("| %-25s | %-7s | %-5s |%n", player.getName(), player.getBowlerStats().getNumberOfWicketTaken(), InningsResult.getNumberOfOverTaken(player));
            }
        }
        System.out.printf("-----------------------------------------------%n");
        System.out.printf("| %-25s | %-7s | %-5s |%n", "Total", battingTeam.getWickets(), InningsResult.getTotalNumberOfOverPlayed(innings));
        System.out.printf("-----------------------------------------------%n%n");
    }
}
