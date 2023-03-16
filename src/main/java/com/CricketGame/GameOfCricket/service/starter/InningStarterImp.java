package com.CricketGame.GameOfCricket.service.starter;

import com.CricketGame.GameOfCricket.constants.Constants;
import com.CricketGame.GameOfCricket.model.Over;
import com.CricketGame.GameOfCricket.model.beans.Ball;
import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.enums.Role;
import com.CricketGame.GameOfCricket.model.enums.Runs;
import com.CricketGame.GameOfCricket.service.playerSelector.BatsmanSelector;
import com.CricketGame.GameOfCricket.service.playerSelector.BowlerSelector;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class InningStarterImp implements InningStarter {

    @Override
    public void play(Innings innings, boolean isFirstInnings, Match match) {
        int wickets = match.getNumberOfPlayersInATeam() - 1;
        Player currentBowler = null;
        Team battingTeam = innings.getBattingTeam();
        Team bowlingTeam = innings.getBowlingTeam();
        Player currentBatsmanStrike1 = battingTeam.getPlayers().get(battingTeam.getWickets());
        Player currentBatsmanStrike2 = battingTeam.getPlayers().get(battingTeam.getWickets() + 1);

        int ballNumber = Constants.START_BALLS_IN_A_OVER + 1;

        outerLoop:
        for (int over = Constants.START_OVER; over < match.getOvers(); over++) {
            Over overObj = new Over();
            overObj.setBalls(new ArrayList<>());
            overObj.setWickets(new ArrayList<>());
            overObj.setPlayedBy(new ArrayList<>());

            currentBowler = BowlerSelector.chooseBowler(bowlingTeam, Optional.ofNullable(currentBowler));
            //            currentBowler.getBowlerStats().setNumberOfOverTaken(currentBowler.getBowlerStats().getNumberOfOverTaken() + 1);
            overObj.setBowler(currentBowler);

            Player temp = currentBatsmanStrike1;
            currentBatsmanStrike1 = currentBatsmanStrike2;
            currentBatsmanStrike2 = temp;

            for (int ball = Constants.START_BALLS_IN_A_OVER; ball < Constants.BALLS_IN_A_OVER; ball++) {
                Ball ballObj = new Ball();
                ballObj.setPlayedBy(currentBatsmanStrike1);
                ballObj.setBallNumber(ballNumber);
                ballNumber++;

                int totalBallsPlayed = currentBatsmanStrike1.getBatsmanStats().getTotalBallsPlayed() + 1;
                int totalBallsDoneByBowler = currentBowler.getBowlerStats().getNumberOfBallsTaken() + 1;

                if (battingTeam.getWickets() == wickets) {
                    break outerLoop;
                }

                Runs currentRuns;
                if (Role.BATSMAN.equals(currentBatsmanStrike1.getPlayerRole())) {
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
                        overObj.setTotalRuns(overObj.getTotalRuns() + currentRuns.getRuns());
                        innings.getOvers().add(overObj);
                        break outerLoop;
                    }

                    currentBatsmanStrike1 = BatsmanSelector.chooseBatsman(battingTeam.getPlayers(),
                            battingTeam.getWickets() + 1);
                } else {

                    int runsMadeByBatsman = currentBatsmanStrike1.getBatsmanStats().getTotalRunsMade() +
                                            currentRuns.getRuns();

                    currentBatsmanStrike1.getBatsmanStats().setTotalRunsMade(runsMadeByBatsman);

                    currentBatsmanStrike1.getBatsmanStats().setTotalBallsPlayed(totalBallsPlayed);

                    currentBowler.getBowlerStats().setNumberOfBallsTaken(totalBallsDoneByBowler);

                    battingTeam.setTotalRuns(battingTeam.getTotalRuns() + currentRuns.getRuns());

                    overObj.setTotalRuns(overObj.getTotalRuns() + currentRuns.getRuns());

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
