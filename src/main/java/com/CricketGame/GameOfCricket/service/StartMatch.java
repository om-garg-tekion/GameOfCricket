package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.Innings;
import com.CricketGame.GameOfCricket.model.classes.Match;
import com.CricketGame.GameOfCricket.model.classes.Team;
import com.CricketGame.GameOfCricket.model.enums.Coin;

import java.util.ArrayList;

public class StartMatch {

    private final Match match = new Match();

    private final Innings firstInnings;
    private final Innings secondInnings;

    private final Team firstTeam;

    private final Team secondTeam;

    public StartMatch(int overs, int noOfPlayers, Team firstTeam, Team secondTeam) {
        match.setFirstTeam(firstTeam); // Initializing first
        match.setSecondTeam(secondTeam); // Initializing second team
        match.setOvers(overs); // Setting the value of overs
        match.setFirstInnings(new Innings());
        match.setSecondInnings(new Innings());
        match.setTeamSize(noOfPlayers);
        this.firstInnings = match.getFirstInnings();
        this.secondInnings = match.getSecondInnings();
        this.firstTeam = match.getFirstTeam();
        this.secondTeam = match.getSecondTeam();
        firstInnings.setOvers(new ArrayList<>());
        secondInnings.setOvers(new ArrayList<>());
    }

    // Method for starting the cricket game
    public void startMatch() {
        Coin tossResult = TossCoin.flip(); // Running toss method

        switch (tossResult) { // Playing match according to the output of toss
            case HEADS -> {
                firstInnings.setBattingTeam(firstTeam);
                firstInnings.setBowlingTeam(secondTeam);
                secondInnings.setBattingTeam(secondTeam);
                secondInnings.setBowlingTeam(firstTeam);
            }
            case TAILS -> {
                firstInnings.setBattingTeam(secondTeam);
                firstInnings.setBowlingTeam(firstTeam);
                secondInnings.setBattingTeam(firstTeam);
                secondInnings.setBowlingTeam(secondTeam);
            }
        }

        System.out.println("First Innings: ");
        PlayMatch.play(firstInnings, true, match);
        System.out.println();
        ScoreBoard.printInningsResult(firstInnings);

        System.out.println("Second Innings: ");
        PlayMatch.play(secondInnings, false, match);
        System.out.println();
        ScoreBoard.printInningsResult(secondInnings);

        ScoreBoard.printFinalResult(match);
    }

    // Method for paying innings, taking team and current innings argument
    // isFirstInnings will be true for first innings and false for second innings


}
