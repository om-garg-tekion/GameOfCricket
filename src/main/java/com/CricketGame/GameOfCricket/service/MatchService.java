package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.*;

public class MatchService {
    private final Team firstTeam;
    private final Team secondTeam;
    private int target = 0;
    private int overs = 0;

    private int wickets = 10;

    private String firstTeamName;
    private String secondTeamName;
    public MatchService(int overs, int noOfPlayers){
        firstTeam = new Team("India"); // Initializing first team
        secondTeam = new Team("Pakistan"); // Initializing second team
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
        for(int over = 0;over < this.overs; over++){
            for(int ball = 0;ball<6;ball++){
                if(team.getWickets() == wickets) {
                    break;
                }
//                int currentRuns = team.players.get(team.wickets).getRuns();
                Points currentRuns = ScorePoints.scorePoints();
                System.out.println(currentRuns);
                if(currentRuns == Points.Wicket)
                    team.setWickets(team.getWickets() + 1);
                else
                    team.setTotalRuns(team.getTotalRuns() + currentRuns.getPointScored());
                if(!isFirstInnings){
                    if(team.getTotalRuns() >= target){
                        System.out.println(team.getName() + " has scored " + team.getTotalRuns() + " runs and lost " + team.getWickets() + " wickets.");
                        System.out.println(team.getName() + " won the match by " + (10 - team.getWickets()) + " wickets.");
                        return;
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
