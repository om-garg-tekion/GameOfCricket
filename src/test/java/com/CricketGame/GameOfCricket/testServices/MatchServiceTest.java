package com.CricketGame.GameOfCricket.testServices;

import com.CricketGame.GameOfCricket.model.beans.Match;
import com.CricketGame.GameOfCricket.repository.MatchRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.MatchService;
import com.CricketGame.GameOfCricket.utils.MatchServiceUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MatchServiceTest {

    @Mock
    MatchRepository matchRepository;

    @InjectMocks
    MatchService matchService;

    private MatchServiceUtilsTest matchServiceUtilsTest;

    @BeforeEach
    public void setUp(){
        matchServiceUtilsTest = new MatchServiceUtilsTest();
    }

    @Test
    public void saveMatchTest(){
        when(matchRepository.save(any(Match.class))).thenReturn(matchServiceUtilsTest.getMatch(1L));

        Assert.assertEquals(matchServiceUtilsTest.getMatch(1L),
                matchService.saveMatch(matchServiceUtilsTest.getMatch(1L)));
    }

    @Test
    public void findByIdTest(){
        when(matchRepository.findById(anyLong())).thenReturn(matchServiceUtilsTest.getNullMatch());

        Assert.assertNull(matchService.findById(anyLong()));
    }

    @Test
    public void validateMatchTest(){
        when(matchRepository.findById(anyLong())).thenReturn(matchServiceUtilsTest.getNullMatch());

        Assert.assertTrue(matchService.validateMatch(anyLong()));
    }

    @Test
    public void getMatchWinnerByIdTest(){
        when(matchRepository.getMatchByWinnerId(anyLong())).thenReturn(matchServiceUtilsTest.getNullMatch());

        Assert.assertSame(Optional.empty(), matchService.getMatchByWinnerId(anyLong()));
    }
}
