package com.CricketGame.GameOfCricket.testServices;


import com.CricketGame.GameOfCricket.model.beans.Team;
import com.CricketGame.GameOfCricket.model.beans.player.Player;
import com.CricketGame.GameOfCricket.model.keys.PlayerKey;
import com.CricketGame.GameOfCricket.model.keys.TeamKey;
import com.CricketGame.GameOfCricket.repository.TeamRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.TeamService;
import com.CricketGame.GameOfCricket.utils.TeamServiceUtilsTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TeamServiceTest {

    @InjectMocks
    TeamService teamService;

    @Mock
    TeamRepository teamRepository;

    private TeamServiceUtilsTest teamServiceUtilsTest;

    @BeforeEach
    public void setUp(){
        teamServiceUtilsTest = new TeamServiceUtilsTest();
    }

    @Test
    public void saveTeamTest(){
        when(teamRepository.save(any(Team.class))).thenReturn(teamServiceUtilsTest.getTeam(new TeamKey(1L, 1L)));

        Assert.assertEquals(teamServiceUtilsTest.getTeam(new TeamKey(1L, 1L))
                ,teamService.saveTeam(teamServiceUtilsTest.getTeam(new TeamKey(1L, 1L))));
    }

    @Test
    public void findByIdTest(){
        when(teamRepository.findById(any(TeamKey.class))).thenReturn(teamServiceUtilsTest.getNullTeam());

        Assert.assertSame(Optional.empty(), teamRepository.findById(any(TeamKey.class)));
    }

    @Test
    public void validatePlayerTest(){
        when(teamRepository.findById(any(TeamKey.class))).thenReturn(teamServiceUtilsTest.getNullTeam());

        Assert.assertFalse(teamService.validateTeam(1L, 1L));
    }

    @Test
    public void getTeamByNameTest(){
        when(teamRepository.getTeamByName(anyString())).thenReturn(teamServiceUtilsTest.getNullTeam());

        Assert.assertSame(Optional.empty(),
                teamService.getTeamByName(anyString()));
    }
}
