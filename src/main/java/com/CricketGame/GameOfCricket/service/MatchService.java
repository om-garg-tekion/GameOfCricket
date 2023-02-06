package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.*;
import com.CricketGame.GameOfCricket.model.enums.Coin;
import com.CricketGame.GameOfCricket.model.enums.Runs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MatchService {

    static final int BALLS_IN_A_OVER = 6;

    private final Match match = new Match();

    private final Innings firstInnings;
    private final Innings secondInnings;

    private final Team firstTeam;

    private final Team secondTeam;

    private final int wickets;

    public MatchService(int overs, int noOfPlayers, List<Player> firstTeamPlayers, List<Player> secondTeamPlayers) {
        match.setFirstTeam(new Team("India")); // Initializing first
        match.setSecondTeam(new Team("Pakistan")); // Initializing second team
        match.getFirstTeam().setPlayers(firstTeamPlayers);
        match.getSecondTeam().setPlayers(secondTeamPlayers);
        match.setOvers(overs); // Setting the value of overs
        match.setFirstInnings(new Innings());
        match.setSecondInnings(new Innings());
        this.firstInnings = match.getFirstInnings();
        this.secondInnings = match.getSecondInnings();
        this.firstTeam = match.getFirstTeam();
        this.secondTeam = match.getSecondTeam();
        this.wickets = noOfPlayers - 1;
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
        play(firstInnings, true);
        play(secondInnings, false);
    }

    // Method for paying innings, taking team and current innings argument
    // isFirstInnings will be true for first innings and false for second innings
    public void play(Innings innings, boolean isFirstInnings) {
        Player currentBowler = null;
        Team battingTeam = innings.getBattingTeam();
        Team bowlingTeam = innings.getBowlingTeam();
        Player currentBatsmanStrike1 = battingTeam.getPlayers().get(battingTeam.getWickets());
        Player currentBatsmanStrike2 = battingTeam.getPlayers().get(battingTeam.getWickets()+1);
        outerLoop:
        for (int over = 0; over < match.getOvers(); over++) {
            Over overObj = new Over();
            overObj.setBalls(new ArrayList<>());
            overObj.setWickets(new ArrayList<>());
            overObj.setPlayedBy(new ArrayList<>());

            System.out.println(over);

            currentBowler = GetBowler.chooseBowler(bowlingTeam, Optional.ofNullable(currentBowler));
            overObj.setBowler(currentBowler);
            System.out.println(currentBowler.getName() + " is going for bowling for this over.");

            Player temp = currentBatsmanStrike1;
            currentBatsmanStrike1 = currentBatsmanStrike2;
            currentBatsmanStrike2 = temp;

            for (int ball = 0; ball < BALLS_IN_A_OVER; ball++) {
//                    System.out.println("Ball number - " + ball);
                Ball ballObj = new Ball();
                ballObj.setPlayedBy(currentBatsmanStrike1);

                int totalBallsPlayed = currentBatsmanStrike1.getAsABatsman().getTotalBallsPlayed() + 1;

                if (battingTeam.getWickets() == wickets) {
                    System.out.println("**************");
                    break outerLoop;
                }

                Runs currentRuns = currentBatsmanStrike1.getAsABatsman().getRuns();
                System.out.println(currentRuns);
                ballObj.setRuns(currentRuns);
                overObj.getBalls().add(ballObj);

                if(!overObj.getPlayedBy().contains(currentBatsmanStrike1)) {
                    overObj.getPlayedBy().add(currentBatsmanStrike1);
                }

                if (currentRuns == Runs.WICKET) {

                    overObj.getWickets().add(currentBatsmanStrike1);

                    battingTeam.setWickets(battingTeam.getWickets() + 1);

                    currentBatsmanStrike1.getAsABatsman().setTotalBallsPlayed(totalBallsPlayed);

                    currentBowler.getAsABowler().setNoOfWicketTaken(currentBowler.getAsABowler().getNoOfWicketTaken() + 1);

                    System.out.println(currentBatsmanStrike1.getName() + " scored - " + currentBatsmanStrike1.getAsABatsman().getTotalRunsMade());
                    System.out.println(currentBatsmanStrike1.getName() + " played " + currentBatsmanStrike1.getAsABatsman().getTotalBallsPlayed() + " balls.");

                    if (battingTeam.getWickets() == wickets) {
                        System.out.println("#################");
                        break outerLoop;
                    }

                    currentBatsmanStrike1 = GetBatsman.chooseBatsman(battingTeam.getPlayers(), battingTeam.getWickets() + 1);
                } else {

                    int runsMadeByBatsman = currentBatsmanStrike1.getAsABatsman().getTotalRunsMade() + currentRuns.getRunsMade();
                    currentBatsmanStrike1.getAsABatsman().setTotalRunsMade(runsMadeByBatsman);
                    currentBatsmanStrike1.getAsABatsman().setTotalBallsPlayed(totalBallsPlayed);

                    battingTeam.setTotalRuns(battingTeam.getTotalRuns() + currentRuns.getRunsMade());

                    overObj.setTotalRuns(overObj.getTotalRuns() + currentRuns.getRunsMade());

                    if (currentRuns == Runs.FOUR) {
                        currentBatsmanStrike1.getAsABatsman().setNumberOfFours(currentBatsmanStrike1.getAsABatsman().getNumberOfFours() + 1);
                    } else if (currentRuns == Runs.SIX) {
                        currentBatsmanStrike1.getAsABatsman().setNumberOfSixes(currentBatsmanStrike1.getAsABatsman().getNumberOfSixes() + 1);
                    }

                    if (currentRuns == Runs.ONE || currentRuns == Runs.THREE || currentRuns == Runs.FIVE) {
                        temp = currentBatsmanStrike1;
                        currentBatsmanStrike1 = currentBatsmanStrike2;
                        currentBatsmanStrike2 = temp;
                    }
                }
                if (!isFirstInnings) {
                    if (battingTeam.getTotalRuns() >= match.getTarget()) {
                        System.out.println(battingTeam.getName() + " has scored " + battingTeam.getTotalRuns() + " runs and lost " + battingTeam.getWickets() + " wickets.");
                        System.out.println(battingTeam.getName() + " won the match by " + (this.wickets + 1 - battingTeam.getWickets()) + " wickets.");
                        return;
                    }
                }
            }

            innings.getOvers().add(overObj);
        }

        System.out.println(battingTeam.getName() + " has scored " + battingTeam.getTotalRuns() + " runs and lost " + battingTeam.getWickets() + " wickets.");
        if (isFirstInnings) {
            match.setTarget(battingTeam.getTotalRuns() + 1);
        } else {
            System.out.println(match.getFirstInnings().getBattingTeam().getName() + " won the match by " + (match.getTarget() - battingTeam.getTotalRuns()) + " runs.");
        }
    }
}
