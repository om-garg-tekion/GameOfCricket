package com.CricketGame.GameOfCricket.service.psvm_service;

import com.CricketGame.GameOfCricket.model.entities.Innings;
import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.model.enums.Coin;

import java.util.ArrayList;

public class BeginMatch
{
    public final Match match = new Match();

    private final Innings firstInnings;

    private final Innings secondInnings;

    private final Team firstTeam;

    private final Team secondTeam;

    public BeginMatch(int overs, int noOfPlayers, Team firstTeam, Team secondTeam) {
        match.setFirstTeam(firstTeam); // Initializing first
        match.setSecondTeam(secondTeam); // Initializing second team
        match.setOvers(overs); // Setting the value of overs
        match.setFirstInnings(new Innings());
        match.setSecondInnings(new Innings());
        match.setNumberOfPlayersInATeam(noOfPlayers);
        this.firstInnings = match.getFirstInnings();
        this.secondInnings = match.getSecondInnings();
        this.firstTeam = match.getFirstTeam();
        this.secondTeam = match.getSecondTeam();
        firstInnings.setOvers(new ArrayList<>());
        secondInnings.setOvers(new ArrayList<>());
    }

    // Method for starting the cricket game
    public Match startMatch() {
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

        playInning("First Innings: ", firstInnings, true);

        playInning("Second Innings: ", secondInnings, false);

        ShowFinalResult.printFinalResult(match);

        return this.match;
    }

    private void playInning(String x, Innings firstInnings, boolean isFirstInnings) {
        System.out.println(x);
        MatchActivity.play(firstInnings, isFirstInnings, match);
        System.out.println();
        ShowInningsResults.printInningsResult(firstInnings);
    }
}
