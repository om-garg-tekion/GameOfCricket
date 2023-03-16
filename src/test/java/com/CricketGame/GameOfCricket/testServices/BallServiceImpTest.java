package com.CricketGame.GameOfCricket.testServices;

import com.CricketGame.GameOfCricket.repository.BallRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.dataAccessIntefaces.BallService;
import com.CricketGame.GameOfCricket.utils.BallServiceUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BallServiceImpTest {

    @Mock
    BallRepository ballRepository;

    @InjectMocks
    BallService ballService;

    private BallServiceUtilsTest ballServiceUtilsTest;

    @BeforeEach
    public void setUp(){
        ballServiceUtilsTest = new BallServiceUtilsTest();
    }

    @Test
    public void testSaveBall(){

        when(ballRepository.save(ballServiceUtilsTest.getBall())).thenReturn(ballServiceUtilsTest.getBall());

        Assert.assertEquals(ballServiceUtilsTest.getBall(), ballService.saveBall(ballServiceUtilsTest.getBall()));
    }

}
