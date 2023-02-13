package com.CricketGame.GameOfCricket.service;

import com.CricketGame.GameOfCricket.model.classes.*;
import com.CricketGame.GameOfCricket.model.enums.Runs;
import com.CricketGame.GameOfCricket.utils.Constants;

import java.util.ArrayList;
import java.util.Optional;

public class MatchActivity {

    static final int BALLS_IN_A_OVER = Constants.BALLS_IN_A_OVER;

    public static void play(Innings innings, boolean isFirstInnings, Match match) {
        int wickets = match.getTeamSize() - 1;
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

            currentBowler = BowlerSelection.chooseBowler(bowlingTeam, Optional.ofNullable(currentBowler));
            currentBowler.getAsABowler().setNumberOfOverTaken(currentBowler.getAsABowler().getNumberOfOverTaken() + 1);
            overObj.setBowler(currentBowler);

            Player temp = currentBatsmanStrike1;
            currentBatsmanStrike1 = currentBatsmanStrike2;
            currentBatsmanStrike2 = temp;

            for (int ball = 0; ball < BALLS_IN_A_OVER; ball++) {
                Ball ballObj = new Ball();
                ballObj.setPlayedBy(currentBatsmanStrike1);

                int totalBallsPlayed = currentBatsmanStrike1.getAsABatsman().getTotalBallsPlayed() + 1;

                if (battingTeam.getWickets() == wickets) {
                    break outerLoop;
                }

                Runs currentRuns = currentBatsmanStrike1.getAsABatsman().getRuns();
                ballObj.setRuns(currentRuns);
                overObj.getBalls().add(ballObj);

                if(!overObj.getPlayedBy().contains(currentBatsmanStrike1)) {
                    overObj.getPlayedBy().add(currentBatsmanStrike1);
                }

                if (currentRuns == Runs.WICKET) {

                    overObj.getWickets().add(currentBatsmanStrike1);

                    battingTeam.setWickets(battingTeam.getWickets() + 1);

                    currentBatsmanStrike1.getAsABatsman().setOutBy(currentBowler);

                    currentBatsmanStrike1.getAsABatsman().setTotalBallsPlayed(totalBallsPlayed);

                    currentBowler.getAsABowler().setNumberOfWicketTaken(currentBowler.getAsABowler().getNumberOfWicketTaken() + 1);

                    if (battingTeam.getWickets() == wickets) {
                        break outerLoop;
                    }

                    currentBatsmanStrike1 = BatsmanSelection.chooseBatsman(battingTeam.getPlayers(), battingTeam.getWickets() + 1);
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
