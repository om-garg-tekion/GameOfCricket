package com.CricketGame.GameOfCricket.service.psvm_service;

import com.CricketGame.GameOfCricket.model.entities.Batsman;
import com.CricketGame.GameOfCricket.model.entities.Bowler;
import com.CricketGame.GameOfCricket.model.entities.Player;
import com.CricketGame.GameOfCricket.model.interfaces.Factory;
import com.CricketGame.GameOfCricket.repository.PlayerRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;


@Service
public class PlayerCreation implements Factory {

    private static final Faker instantiateFaker = FakerGenerator.getInstance();

    public static Long playerId;

//    @Autowired
//    private final PlayerService playerService;


    private final PlayerRepository playerRepository;

    public PlayerCreation(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //    public PlayerCreation(PlayerService playerService) {
//        this.playerService = playerService;
//    }

    @Override
    public Player create(){

        String name = instantiateFaker.name().fullName();

        Player player = new Player();

        player.setName(name);
        player.setBatsmanStats(new Batsman());
        player.setBowlerStats(new Bowler());

//        playerId = playerService.savePlayer(player).getId();

        playerId = playerRepository.save(player).getId();
        return player;
    }
}
