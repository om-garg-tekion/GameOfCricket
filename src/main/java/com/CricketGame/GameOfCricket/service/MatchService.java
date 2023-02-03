package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.*;

import java.util.ArrayList;

public class MatchService {
    private final Team firstTeam;
    private final Team secondTeam;
    private int target = 0;
    private int overs = 0;

    private int wickets = 0;

    private String firstTeamName;
    private String secondTeamName;
    public MatchService(int overs, int noOfPlayers, ArrayList<Player> firstTeam, ArrayList<Player> secondTeam){
        this.firstTeam = new Team("India"); // Initializing first team
        this.secondTeam = new Team("Pakistan"); // Initializing second team
        this.firstTeam.setPlayers(firstTeam);
        this.secondTeam.setPlayers(secondTeam);
        this.overs = overs; // Setting the value of overs
        this.wickets = noOfPlayers - 1;
    }
    // Method for starting the cricket game
    public void startMatch(){
        Coin tossResult = CoinTossing.flip(); // Running toss method
        switch (tossResult) { // Playing match according to the output of toss
            case HEADS -> {
                this.firstTeamName = firstTeam.getName();
                this.secondTeamName = secondTeam.getName();
                play(firstTeam, secondTeam, true);
                play(secondTeam, firstTeam, false);
            }
            case TAILS -> {
                this.firstTeamName = secondTeam.getName();
                this.secondTeamName = firstTeam.getName();
                play(secondTeam, firstTeam, true);
                play(firstTeam, secondTeam, false);
            }
        }
    }

    // Method for paying innings, taking team and current innings argument
    // isFirstInnings will be true for first innings and false for second innings
    public void play(Team battingTeam, Team bowlingTeam, boolean isFirstInnings){
        int currentOver = 0;
        int currentBall = 0;
        Player currentBowler = null;
        outerLoop:
        for(Player player : battingTeam.getPlayers()){
            nextPlayer:
            for(int over = currentOver; over < this.overs; over++){
                currentOver = over;
                if(currentBall == 6 || currentBall == 0) {
                    currentBall = 0;
                    currentBowler = BowlerService.chooseBowler(bowlingTeam, currentBowler);
                    System.out.println(currentBowler.getName() + " is going for bowling for this over.");
                }
                for(int ball = currentBall; ball < 6; ball++){
                    System.out.println("Ball number - " + ball);
                    int totalBallsPlayed = player.getAsABatsman().getTotalBallsPlayed() + 1;
                    currentBall = ball;
                    if(battingTeam.getWickets() == wickets) {
                        break outerLoop;
                    }
                    Points currentRuns = player.getAsABatsman().getRuns();
                    System.out.println(currentRuns);
                    if(currentRuns == Points.WICKET) {
                        currentBall++;
                        battingTeam.setWickets(battingTeam.getWickets() + 1);
                        System.out.println(player.getName() + " scored - " + player.getAsABatsman().getTotalRunsMade());
                        break nextPlayer;
                    } else {
                        int runsMadeByBatsman = player.getAsABatsman().getTotalRunsMade() + currentRuns.getPointScored();
                        player.getAsABatsman().setTotalRunsMade(runsMadeByBatsman);
                        player.getAsABatsman().setTotalBallsPlayed(totalBallsPlayed);
                        battingTeam.setTotalRuns(battingTeam.getTotalRuns() + currentRuns.getPointScored());
                    }
                    if(!isFirstInnings){
                        if(battingTeam.getTotalRuns() >= target){
                            System.out.println(battingTeam.getName() + " has scored " + battingTeam.getTotalRuns() + " runs and lost " + battingTeam.getWickets() + " wickets.");
                            System.out.println(battingTeam.getName() + " won the match by " + (this.wickets+1 - battingTeam.getWickets()) + " wickets.");
                            return;
                        }
                    }
                }
                currentBall = 0;
            }
        }
        System.out.println(battingTeam.getName() + " has scored " + battingTeam.getTotalRuns() + " runs and lost " + battingTeam.getWickets() + " wickets.");
        if(isFirstInnings) {
            target = battingTeam.getTotalRuns() + 1;
        }
        else{
            System.out.println(this.firstTeamName + " won the match by " + (target - battingTeam.getTotalRuns()) + " runs.");
        }
    }
}
