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
                play(firstTeam, true);
                play(secondTeam, false);
            }
            case TAILS -> {
                this.firstTeamName = secondTeam.getName();
                this.secondTeamName = firstTeam.getName();
                play(secondTeam, true);
                play(firstTeam, false);
            }
        }
    }

    // Method for paying innings, taking team and current innings argument
    // isFirstInnings will be true for first innings and false for second innings
    public void play(Team team, boolean isFirstInnings){
        int currentOver = 0;
        int currentBall = 0;
        System.out.println(team.getPlayers());
        outerLoop:
        for(Player player : team.getPlayers()){
            nextPlayer:
            for(int over = currentOver; over < this.overs; over++){
                currentOver = over;
                for(int ball = currentBall; ball < 6; ball++){
                    currentBall = ball;
                    if(team.getWickets() == wickets) {
                        break outerLoop;
                    }
                    Points currentRuns = player.getAsABatsman().getRuns();
                    System.out.println(currentRuns);
                    if(currentRuns == Points.WICKET) {
                        team.setWickets(team.getWickets() + 1);
                        System.out.println(player.getName() + " scored - " + player.getAsABatsman().getTotalRunsMade());
                        break nextPlayer;
                    } else {
                        int runsMadeByBatsman = player.getAsABatsman().getTotalRunsMade() + currentRuns.getPointScored();
                        player.getAsABatsman().setTotalRunsMade(runsMadeByBatsman);
                        team.setTotalRuns(team.getTotalRuns() + currentRuns.getPointScored());
                    }
                    if(!isFirstInnings){
                        if(team.getTotalRuns() >= target){
                            System.out.println(team.getName() + " has scored " + team.getTotalRuns() + " runs and lost " + team.getWickets() + " wickets.");
                            System.out.println(team.getName() + " won the match by " + (this.wickets+1 - team.getWickets()) + " wickets.");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(team.getName() + " has scored " + team.getTotalRuns() + " runs and lost " + team.getWickets() + " wickets.");
        if(isFirstInnings) {
            target = team.getTotalRuns() + 1;
        }
        else{
            System.out.println(this.firstTeamName + " won the match by " + (target - team.getTotalRuns()) + " runs.");
        }
    }
}
