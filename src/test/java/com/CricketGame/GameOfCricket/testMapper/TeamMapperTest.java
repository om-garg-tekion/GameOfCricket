package com.CricketGame.GameOfCricket.testMapper;

import com.CricketGame.GameOfCricket.service.mapper.TeamMapper;
import com.CricketGame.GameOfCricket.utils.PlayerMapperUtilTest;
import com.CricketGame.GameOfCricket.utils.TeamMapperUtilsTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.OptionalInt;
import java.util.OptionalLong;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TeamMapperTest {

    @Mock
    TeamMapper teamMapper;

    private TeamMapperUtilsTest teamMapperUtilsTest;

    @BeforeEach
    public void setUp() {
        teamMapperUtilsTest = new TeamMapperUtilsTest();
    }

    @Test
    public void toTeamTest(){
        Assert.assertEquals(teamMapperUtilsTest.getTeam(OptionalLong.empty(), 1L, "India", OptionalInt.empty(),
                OptionalInt.empty()), teamMapper.toTeam(teamMapperUtilsTest.getTeamDto(1L, 1L, "India", 1, 100)));
    }

    @Test
    public void toTeamDtoTest(){
        Assert.assertEquals(teamMapperUtilsTest.getTeamDto(1L, 1L, "India", 1, 100),
                teamMapper.toTeamDto(teamMapperUtilsTest.getTeam(OptionalLong.of(1L), 1L, "India", OptionalInt.of(1),
                        OptionalInt.of(100)
                        )));
    }
}
