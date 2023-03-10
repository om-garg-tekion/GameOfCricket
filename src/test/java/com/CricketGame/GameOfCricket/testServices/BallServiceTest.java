package com.CricketGame.GameOfCricket.testServices;

import com.CricketGame.GameOfCricket.service.dataAccessService.BallService;
import com.CricketGame.GameOfCricket.utils.BallServiceUtilsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BallServiceTest {

    @Mock
    BallService ballService;

    private BallServiceUtilsTest ballServiceUtilsTest;

    @BeforeEach
    public void setUp(){
        ballServiceUtilsTest = new BallServiceUtilsTest();
    }

    @Test
    public void testSaveBall(){
        doNothing().when(ballService).saveBall(ballServiceUtilsTest.getBall());

        ballService.saveBall(ballServiceUtilsTest.getBall());

        verify(ballService, times(1)).saveBall(ballServiceUtilsTest.getBall());
    }

}
