package com.CricketGame.GameOfCricket.testServices;

import com.CricketGame.GameOfCricket.model.beans.player.Batsman;
import com.CricketGame.GameOfCricket.repository.BatsmanRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.BatsmanStatsService;
import com.CricketGame.GameOfCricket.utils.BatsmanStatsServiceUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BatsmanStatsServiceTest {

    @Mock
    BatsmanRepository batsmanRepository;

    @InjectMocks
    BatsmanStatsService batsmanStatsService;

    private BatsmanStatsServiceUtilsTest batsmanStatsServiceUtilsTest;

    @BeforeEach
    public void setUp(){
        batsmanStatsServiceUtilsTest = new BatsmanStatsServiceUtilsTest();
    }

    @Test
    public void testSaveBatsmanStats(){
        when(batsmanRepository.save(any(Batsman.class))).thenReturn(batsmanStatsServiceUtilsTest.getBatsman(1L));

        Assert.assertEquals(batsmanStatsServiceUtilsTest.getBatsman(1L),
                batsmanStatsService.saveBatsmanStats(batsmanStatsServiceUtilsTest.getBatsman(1L)));
    }
}
