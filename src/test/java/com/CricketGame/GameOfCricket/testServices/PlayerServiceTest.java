package com.CricketGame.GameOfCricket.testServices;

import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.keys.PlayerKey;
import com.CricketGame.GameOfCricket.repository.PlayerRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.PlayerService;
import com.CricketGame.GameOfCricket.utils.PlayerServiceUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PlayerServiceTest {

    @Mock
    PlayerRepository playerRepository;

    @InjectMocks
    PlayerService playerService;

    private PlayerServiceUtilsTest playerServiceUtilsTest;

    @BeforeEach
    public void setUp(){
        playerServiceUtilsTest = new PlayerServiceUtilsTest();
    }

    @Test
    public void savePlayerTest(){
        when(playerRepository.save(any(Player.class))).thenReturn(playerServiceUtilsTest.getPlayer(new PlayerKey(1L,
                1L, 1L)));

        Assert.assertEquals(playerServiceUtilsTest.getPlayer(new PlayerKey(1L,
                        1L, 1L)),
                playerService.savePlayer(playerServiceUtilsTest.getPlayer(new PlayerKey(1L,
                        1L, 1L))));
    }

    @Test
    public void findByIdTest(){
        when(playerRepository.findById(any(PlayerKey.class))).thenReturn(playerServiceUtilsTest.getOptionalPlayer());

        Assert.assertSame(Optional.empty(), playerRepository.findById(any(PlayerKey.class)));

        when(playerRepository.findById(new PlayerKey(1L, 1L, 1L))).thenReturn(Optional.of(playerServiceUtilsTest.getPlayer(new PlayerKey(1L, 1L, 1L))));

        Assert.assertFalse(
                playerRepository.findById(new PlayerKey(1L, 1L, 1L)).isEmpty());
    }

    @Test
    public void validatePlayerTest(){
        when(playerRepository.findById(any(PlayerKey.class))).thenReturn(playerServiceUtilsTest.getOptionalPlayer());

        Assert.assertTrue(playerService.validatePlayer(1L, 1L, 1L));

        when(playerRepository.findById(any(PlayerKey.class))).thenReturn(Optional.of(playerServiceUtilsTest.getPlayer(new PlayerKey(1L, 1L, 1L))));

        Assert.assertFalse(playerService.validatePlayer(1L, 1L, 1L));
    }

    @Test
    public void getPlayerByNameTest(){
        when(playerRepository.getPlayerByName(anyString())).thenReturn(Optional.of(
                Collections.singletonList(playerServiceUtilsTest.getNullPlayer())));

        Assert.assertFalse(
                playerService.getPlayerByName(anyString()).get().isEmpty());
    }

    @Test
    public void getPlayerByBattingOrderNumber(){
        when(playerRepository.getPlayerByBattingOrderNumber(anyInt(), anyLong())).thenReturn(playerServiceUtilsTest.getOptionalPlayer());

        Assert.assertTrue(playerService.getPlayerByBattingOrderNumber(anyInt(), anyLong()).isEmpty());
    }
}
