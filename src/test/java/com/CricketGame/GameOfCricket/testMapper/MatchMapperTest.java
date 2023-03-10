package com.CricketGame.GameOfCricket.testMapper;

import com.CricketGame.GameOfCricket.service.mapper.MatchMapper;
import com.CricketGame.GameOfCricket.utils.MatchMapperUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MatchMapperTest {

    @Mock
    MatchMapper matchMapper;

    private MatchMapperUtilsTest matchMapperUtilsTest;

    @BeforeEach
    public void setUp(){
        matchMapperUtilsTest = new MatchMapperUtilsTest();
    }

    @Test
    public void toMatchTest(){
        Assert.assertEquals(matchMapperUtilsTest.getMatch(1L, Optional.empty(), 11, 20, Optional.empty()),
                matchMapper.toMatch(matchMapperUtilsTest.getMatchDto(1L, 1L, 11, 20, 100)));
    }

    @Test
    public void toMatchDtoTest(){
        Assert.assertEquals(matchMapperUtilsTest.getMatchDto(1L, 1L, 11, 20, 100),
                matchMapper.toMatchDto(matchMapperUtilsTest.getMatch(1L, Optional.of(1L), 11, 20, Optional.of(100))));
    }
}
