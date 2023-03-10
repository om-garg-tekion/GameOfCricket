package com.CricketGame.GameOfCricket.testServices;

import com.CricketGame.GameOfCricket.model.beans.player.Bowler;
import com.CricketGame.GameOfCricket.repository.BowlerRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.BowlerStatsService;
import com.CricketGame.GameOfCricket.utils.BowlerStatsServiceUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BowlerStatsServiceTest {

    @Mock
    BowlerRepository bowlerRepository;

    @InjectMocks
    BowlerStatsService bowlerStatsService;

    private BowlerStatsServiceUtilsTest bowlerStatsServiceUtilsTest;

    @BeforeEach
    public void setUp(){
        bowlerStatsServiceUtilsTest = new BowlerStatsServiceUtilsTest();
    }

    @Test
    public void saveBowlerStatsTest(){
        when(bowlerRepository.save(any(Bowler.class))).thenReturn(bowlerStatsServiceUtilsTest.getBowler(1L));

        Assert.assertEquals(bowlerStatsServiceUtilsTest.getBowler(1L),
                bowlerStatsService.saveBowlerStats(bowlerStatsServiceUtilsTest.getBowler(1L)));
    }

}
