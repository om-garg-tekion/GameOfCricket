package com.CricketGame.GameOfCricket.service.starter;

import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.enums.Coin;
import com.CricketGame.GameOfCricket.service.coinTosser.CoinTosser;
import com.CricketGame.GameOfCricket.service.results.FinalResult;
import com.CricketGame.GameOfCricket.service.results.InningsResult;

import java.util.ArrayList;

public class MatchStarter
{
    public final Match match = new Match();

    private final Innings firstInnings;

    private final Innings secondInnings;

    private final Team firstTeam;

    private final Team secondTeam;

    public MatchStarter(Match match) {
        this.match.setId(match.getId());
        this.match.setFirstTeam(match.getFirstTeam()); // Initializing first
        this.match.setSecondTeam(match.getSecondTeam()); // Initializing second team
        this.match.setOvers(match.getOvers()); // Setting the value of overs
        this.match.setFirstInnings(new Innings());
        this.match.setSecondInnings(new Innings());
        this.match.setNumberOfPlayersInATeam(match.getNumberOfPlayersInATeam());
        this.firstInnings = this.match.getFirstInnings();
        this.secondInnings = this.match.getSecondInnings();
        this.firstTeam = this.match.getFirstTeam();
        this.secondTeam = this.match.getSecondTeam();
        firstInnings.setOvers(new ArrayList<>());
        secondInnings.setOvers(new ArrayList<>());
    }

    // Method for starting the cricket game
    public Match startMatch() {
        Coin tossResult = CoinTosser.flip(); // Running toss method

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

        FinalResult.printFinalResult(match);

        return this.match;
    }

    private void playInning(String x, Innings firstInnings, boolean isFirstInnings) {
        System.out.println(x);
        InningStarter.play(firstInnings, isFirstInnings, match);
        System.out.println();
        InningsResult.printInningsResult(firstInnings);
    }
}
