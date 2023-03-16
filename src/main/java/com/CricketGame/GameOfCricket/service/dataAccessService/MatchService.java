package com.CricketGame.GameOfCricket.service.dataAccessService;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Batsman;
import com.CricketGame.GameOfCricket.model.beans.player.Bowler;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MatchService{

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private BatsmanRepository batsmanRepository;

    @Autowired
    private BowlerRepository bowlerRepository;

    public Match saveMatch(Match match){
        return this.matchRepository.save(match);
    }

    public Match findById(Long id) {
        return this.matchRepository.findById(id).orElse(null);
    }

    public boolean validateMatch(Long matchId) {

        Optional<Match> match = this.matchRepository.findById(matchId);
        try{
            if(match.isEmpty()){
                throw new IllegalArgumentException("Error: Match with given this id is not present");
            } else if (!Objects.isNull(match.get().getWinnerTeamId()) && match.get().getTarget() != 0) {
                throw new IllegalArgumentException("Error: Match with given this id is already played");
            }
        }catch(Exception e){
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public Optional<Match> getMatchByWinnerId(long id){
        Optional<Match> match = this.matchRepository.getMatchByWinnerId(id);
        if(match.isPresent()){
            Optional<List<Team>> teams = teamRepository.getTeamByMatchId(match.get().getId());
            if(teams.isPresent() && teams.get().size() == 2){
                match.get().setFirstTeam(teams.get().get(0));
                match.get().setSecondTeam(teams.get().get(1));

                Optional<List<Player>> firstTeamPlayers = playerRepository.getPlayerByMatchIdAndTeamId(id,
                        match.get().getFirstTeam().getId());
                if(firstTeamPlayers.isEmpty()){
                    return match;
                }

                for(Player player : firstTeamPlayers.get()){
                    if(!Objects.isNull(player.getBatsmanStatsId())){
                        Optional<Batsman> tempBatsman = batsmanRepository.findById(player.getBatsmanStatsId());
                        tempBatsman.ifPresent(player::setBatsmanStats);
                    }
                    if(!Objects.isNull(player.getBowlingStatsId())){
                        Optional<Bowler> tempBowler = bowlerRepository.findById(player.getBowlingStatsId());
                        tempBowler.ifPresent(player::setBowlerStats);
                    }
                }

                match.get().getFirstTeam().setPlayers(firstTeamPlayers.get());
                Optional<List<Player>> secondTeamPlayers = playerRepository.getPlayerByMatchIdAndTeamId(id,
                        match.get().getSecondTeam().getId());
                if(secondTeamPlayers.isEmpty()){
                    return match;
                }

                for(Player player : secondTeamPlayers.get()){
                    if(!Objects.isNull(player.getBatsmanStatsId())){
                        Optional<Batsman> tempBatsman = batsmanRepository.findById(player.getBatsmanStatsId());
                        tempBatsman.ifPresent(player::setBatsmanStats);
                    }
                    if(!Objects.isNull(player.getBowlingStatsId())){
                        Optional<Bowler> tempBowler = bowlerRepository.findById(player.getBowlingStatsId());
                        tempBowler.ifPresent(player::setBowlerStats);
                    }
                }

                match.get().getSecondTeam().setPlayers(secondTeamPlayers.get());
                return match;
            }
        }
        return Optional.empty();
    }

    public Optional<Match> getScoreBoardByMatchId(long id) {
        Optional<Match> match = this.matchRepository.findById(id);
        if(match.isPresent()){
            Optional<List<Team>> teams = teamRepository.getTeamByMatchId(match.get().getId());
            if(teams.isPresent() && teams.get().size() == 2){
                match.get().setFirstTeam(teams.get().get(0));
                match.get().setSecondTeam(teams.get().get(1));

                Optional<List<Player>> firstTeamPlayers = playerRepository.getPlayerByMatchIdAndTeamId(id,
                        match.get().getFirstTeam().getId());
                if(firstTeamPlayers.isEmpty()){
                    return match;
                }

                for(Player player : firstTeamPlayers.get()){
                    if(!Objects.isNull(player.getBatsmanStatsId())){
                        Optional<Batsman> tempBatsman = batsmanRepository.findById(player.getBatsmanStatsId());
                        tempBatsman.ifPresent(player::setBatsmanStats);
                    }
                    if(!Objects.isNull(player.getBowlingStatsId())){
                        Optional<Bowler> tempBowler = bowlerRepository.findById(player.getBowlingStatsId());
                        tempBowler.ifPresent(player::setBowlerStats);
                    }
                }

                match.get().getFirstTeam().setPlayers(firstTeamPlayers.get());
                Optional<List<Player>> secondTeamPlayers = playerRepository.getPlayerByMatchIdAndTeamId(id,
                        match.get().getSecondTeam().getId());
                if(secondTeamPlayers.isEmpty()){
                    return match;
                }

                for(Player player : secondTeamPlayers.get()){
                    if(!Objects.isNull(player.getBatsmanStatsId())){
                        Optional<Batsman> tempBatsman = batsmanRepository.findById(player.getBatsmanStatsId());
                        tempBatsman.ifPresent(player::setBatsmanStats);
                    }
                    if(!Objects.isNull(player.getBowlingStatsId())){
                        Optional<Bowler> tempBowler = bowlerRepository.findById(player.getBowlingStatsId());
                        tempBowler.ifPresent(player::setBowlerStats);
                    }
                }

                match.get().getSecondTeam().setPlayers(secondTeamPlayers.get());
                return match;
            }
        }
        return Optional.empty();
    }
}
