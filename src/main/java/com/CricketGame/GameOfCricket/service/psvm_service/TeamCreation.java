package com.CricketGame.GameOfCricket.service.psvm_service;

import com.CricketGame.GameOfCricket.model.entities.Player;
import com.CricketGame.GameOfCricket.model.entities.Team;
import com.CricketGame.GameOfCricket.model.enums.PlayerRole;
import com.CricketGame.GameOfCricket.model.interfaces.Factory;
import com.CricketGame.GameOfCricket.model.interfaces.TeamFactory;
import com.CricketGame.GameOfCricket.repository.PlayerRepository;
import com.CricketGame.GameOfCricket.repository.TeamRepository;
import com.CricketGame.GameOfCricket.utils.Constants;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamCreation implements TeamFactory {

    private static final Faker instantiateFaker = FakerGenerator.getInstance();

//    @Autowired
//    private final TeamService teamService;

//    @Autowired
//    private final PlayerService playerService;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public static Long teamId;

    public TeamCreation(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    //    public TeamCreation(TeamService teamService, PlayerService playerService) {
//        this.teamService = teamService;
//        this.playerService = playerService;
//    }

    @Override
    public Team create(int noOfPlayers){

        int battingOrderNumber = Constants.START_OF_BATTING_ORDER_NUMBER;
        List<Player> players = new ArrayList<>();
        Factory playerFactory = new PlayerCreation(playerRepository);

        Team team = new Team(instantiateFaker.name().fullName());

        int temp = 0;

        for(int i=0; i<noOfPlayers; i++){
            Player player = (Player) playerFactory.create();
            player.setBattingOrderNumber(battingOrderNumber);
            if(temp < noOfPlayers/2){
                player.setPlayerRole(PlayerRole.BATSMAN);
            } else {
                player.setPlayerRole(PlayerRole.BOWLER);
            }
            players.add(player);
            temp++;
            battingOrderNumber++;
            playerRepository.save(player);
        }

        players.sort(Comparator.comparingInt(Player::getBattingOrderNumber));

        team.setPlayers(players);

        teamId = teamRepository.save(team).getId();

        return team;
    }

}
