package com.CricketGame.GameOfCricket.service.starter.matchStarter;

import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.enums.Coin;
import com.CricketGame.GameOfCricket.service.coinTosser.CoinTosser;
import com.CricketGame.GameOfCricket.service.results.FinalResult;
import com.CricketGame.GameOfCricket.service.results.InningsResult;
import com.CricketGame.GameOfCricket.service.starter.inningStarter.InningStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MatchStarterImp implements MatchStarter {
    @Autowired
    private InningStarter inningStarter;

    @Override
    public Match matchInit(Match match){
        match.setFirstInnings(new Innings());
        match.setSecondInnings(new Innings());
        return match;
    }

    @Override
    // Method for starting the cricket game
    public void startMatch(Match match, Innings firstInnings, Innings secondInnings, Team firstTeam, Team secondTeam) {
                firstInnings.setOvers(new ArrayList<>());
                secondInnings.setOvers(new ArrayList<>());

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

        playInning("First Innings: ", firstInnings, true, match);

        playInning("Second Innings: ", secondInnings, false, match);

        FinalResult.printFinalResult(match);
    }

    @Override
    public void playInning(String x, Innings firstInnings, boolean isFirstInnings, Match match) {
        System.out.println(x);
        inningStarter.play(firstInnings, isFirstInnings, match);
        System.out.println();
        InningsResult.printInningsResult(firstInnings);
    }
}
