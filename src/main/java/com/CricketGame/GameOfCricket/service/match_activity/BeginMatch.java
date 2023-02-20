package com.CricketGame.GameOfCricket.service.match_activity;

import com.CricketGame.GameOfCricket.model.entities.Innings;
import com.CricketGame.GameOfCricket.model.entities.Match;
import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.model.enums.Coin;
import com.CricketGame.GameOfCricket.service.TossCoin;
import com.CricketGame.GameOfCricket.service.show_results.ShowFinalResult;
import com.CricketGame.GameOfCricket.service.show_results.ShowInningsResults;

import java.util.ArrayList;

public class BeginMatch
{
    public final Match match;

    private final Innings firstInnings;

    private final Innings secondInnings;

    private final Team firstTeam;

    private final Team secondTeam;

    public BeginMatch(Match match) {
        this.match = match;
        this.match.setFirstInnings(new Innings());
        this.match.setSecondInnings(new Innings());
        this.firstInnings = this.match.getFirstInnings();
        this.secondInnings = this.match.getSecondInnings();
        this.firstTeam = this.match.getFirstTeam();
        this.secondTeam = this.match.getSecondTeam();
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
        System.out.println(match);
        System.out.println(x);
        MatchActivity.play(firstInnings, isFirstInnings, match);
        System.out.println();
        ShowInningsResults.printInningsResult(firstInnings);
    }
}
