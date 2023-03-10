package com.CricketGame.GameOfCricket.testMapper;

import com.CricketGame.GameOfCricket.model.enums.Role;
import com.CricketGame.GameOfCricket.service.mapper.PlayerMapper;
import com.CricketGame.GameOfCricket.utils.PlayerMapperUtilTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.OptionalLong;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PlayerMapperTest {

    @Mock
    PlayerMapper playerMapper;

    private PlayerMapperUtilTest playerMapperUtilTest;

    @BeforeEach
    public void setUp() {
        playerMapperUtilTest = new PlayerMapperUtilTest();
    }

    @Test
    public void toPlayerTest() {
        Assert.assertEquals(playerMapperUtilTest.getPlayer(OptionalLong.empty(), 1L, 1L, OptionalLong.empty(),
                        OptionalLong.empty(),
                        "Om",
                        "BATSMAN", 1), playerMapper.toPlayer(playerMapperUtilTest.getPlayerDTO(1L, 1L, 1L, 1L, 1L,
                "Om", Role.BATSMAN, 1)));
    }

    @Test
    public void toPlayerDtoTest() {
       Assert.assertEquals(playerMapperUtilTest.getPlayerDTO(1L, 1L, 1L, 1L, 1L,
               "Om", Role.BATSMAN, 1), playerMapper.toPlayerDto(playerMapperUtilTest.getPlayer(OptionalLong.of(1L),
               1L, 1L, OptionalLong.of(1L),
               OptionalLong.of(1L),
               "Om",
               "BATSMAN", 1)));
    }
}
