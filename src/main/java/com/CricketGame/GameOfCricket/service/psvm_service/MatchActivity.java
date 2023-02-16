package com.CricketGame.GameOfCricket.service.psvm_service;

import com.CricketGame.GameOfCricket.model.entities.*;
import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import com.CricketGame.GameOfCricket.model.enums.Runs;
import com.CricketGame.GameOfCricket.utils.Constants;

import java.util.ArrayList;
import java.util.Optional;

public class MatchActivity {

    static final int BALLS_IN_A_OVER = Constants.BALLS_IN_A_OVER;
    static final int START_BALLS_IN_A_OVER = Constants.START_BALLS_IN_A_OVER;

    static final int START_OVER = Constants.START_OVER;

    public static void play(Innings innings, boolean isFirstInnings, Match match) {
        int wickets = match.getNumberOfPlayersInATeam() - 1;
        Player currentBowler = null;
        Team battingTeam = innings.getBattingTeam();
        Team bowlingTeam = innings.getBowlingTeam();
        Player currentBatsmanStrike1 = battingTeam.getPlayers().get(battingTeam.getWickets());
        Player currentBatsmanStrike2 = battingTeam.getPlayers().get(battingTeam.getWickets() + 1);

        outerLoop:
        for (int over = START_OVER; over < match.getOvers(); over++) {
            Over overObj = new Over();
            overObj.setBalls(new ArrayList<>());
            overObj.setWickets(new ArrayList<>());
            overObj.setPlayedBy(new ArrayList<>());

            currentBowler = BowlerSelection.chooseBowler(bowlingTeam, Optional.ofNullable(currentBowler));
            //            currentBowler.getBowlerStats().setNumberOfOverTaken(currentBowler.getBowlerStats().getNumberOfOverTaken() + 1);
            overObj.setBowler(currentBowler);

            Player temp = currentBatsmanStrike1;
            currentBatsmanStrike1 = currentBatsmanStrike2;
            currentBatsmanStrike2 = temp;

            for (int ball = START_BALLS_IN_A_OVER; ball < BALLS_IN_A_OVER; ball++) {
                Ball ballObj = new Ball();
                ballObj.setPlayedBy(currentBatsmanStrike1);

                int totalBallsPlayed = currentBatsmanStrike1.getBatsmanStats().getTotalBallsPlayed() + 1;
                int totalBallsDoneByBowler = currentBowler.getBowlerStats().getNumberOfBallsTaken() + 1;

                if (battingTeam.getWickets() == wickets) {
                    break outerLoop;
                }

                Runs currentRuns;
                if (PlayerRole.BATSMAN.equals(currentBatsmanStrike1.getPlayerRole())) {
                    currentRuns = currentBatsmanStrike1.getBatsmanStats().getRunsForBatsman();
                } else {
                    currentRuns = currentBatsmanStrike1.getBatsmanStats().getRunsForBowler();
                }
                ballObj.setRuns(currentRuns);
                overObj.getBalls().add(ballObj);

                if (!overObj.getPlayedBy().contains(currentBatsmanStrike1)) {
                    overObj.getPlayedBy().add(currentBatsmanStrike1);
                }

                if (Runs.WICKET.equals(currentRuns)) {

                    overObj.getWickets().add(currentBatsmanStrike1);

                    battingTeam.setWickets(battingTeam.getWickets() + 1);

                    currentBatsmanStrike1.getBatsmanStats().setOutBy(currentBowler);

                    currentBatsmanStrike1.getBatsmanStats().setTotalBallsPlayed(totalBallsPlayed);

                    currentBowler.getBowlerStats().setNumberOfBallsTaken(totalBallsDoneByBowler);

                    currentBowler.getBowlerStats()
                                 .setNumberOfWicketTaken(currentBowler.getBowlerStats().getNumberOfWicketTaken() + 1);

                    if (battingTeam.getWickets() == wickets) {
                        overObj.setTotalRuns(overObj.getTotalRuns() + currentRuns.getRunsMade());
                        innings.getOvers().add(overObj);
                        break outerLoop;
                    }

                    currentBatsmanStrike1 = BatsmanSelection.chooseBatsman(battingTeam.getPlayers(),
                            battingTeam.getWickets() + 1);
                } else {

                    int runsMadeByBatsman = currentBatsmanStrike1.getBatsmanStats().getTotalRunsMade() +
                                            currentRuns.getRunsMade();

                    currentBatsmanStrike1.getBatsmanStats().setTotalRunsMade(runsMadeByBatsman);

                    currentBatsmanStrike1.getBatsmanStats().setTotalBallsPlayed(totalBallsPlayed);

                    currentBowler.getBowlerStats().setNumberOfBallsTaken(totalBallsDoneByBowler);

                    battingTeam.setTotalRuns(battingTeam.getTotalRuns() + currentRuns.getRunsMade());

                    overObj.setTotalRuns(overObj.getTotalRuns() + currentRuns.getRunsMade());

                    if (Runs.FOUR.equals(currentRuns)) {
                        currentBatsmanStrike1.getBatsmanStats().setNumberOfFours(
                                currentBatsmanStrike1.getBatsmanStats().getNumberOfFours() + 1);
                    } else if (Runs.SIX.equals(currentRuns)) {
                        currentBatsmanStrike1.getBatsmanStats().setNumberOfSixes(
                                currentBatsmanStrike1.getBatsmanStats().getNumberOfSixes() + 1);
                    }

                    if (Runs.ONE.equals(currentRuns) || Runs.THREE.equals(currentRuns) ||
                        Runs.FIVE.equals(currentRuns)) {
                        temp = currentBatsmanStrike1;
                        currentBatsmanStrike1 = currentBatsmanStrike2;
                        currentBatsmanStrike2 = temp;
                    }
                }
                if (!isFirstInnings) {
                    if (battingTeam.getTotalRuns() >= match.getTarget()) {
                        innings.getOvers().add(overObj);
                        return;
                    }
                }
            }

            innings.getOvers().add(overObj);
        }

        if (isFirstInnings) {
            match.setTarget(battingTeam.getTotalRuns() + 1);
        }
    }
}
