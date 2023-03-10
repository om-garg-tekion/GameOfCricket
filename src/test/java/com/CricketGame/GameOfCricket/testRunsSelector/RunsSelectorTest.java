package com.CricketGame.GameOfCricket.testRunsSelector;

import com.CricketGame.GameOfCricket.service.runsSelector.RunsSelector;
import com.CricketGame.GameOfCricket.service.singletonInstantiator.RandomNumberGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RunsSelectorTest {

    @Mock
    RandomNumberGenerator randomNumberGenerator;

    @InjectMocks
    RunsSelector runsSelector;

    @Test
    public void testGetRandomRunsForBatsman(){
        when(randomNumberGenerator.nextInt()).thenReturn(0);

        Assert.assertNotNull(runsSelector.getRandomRunsForBatsman());
    }

    @Test
    public void testGetRandomRunsForBowler(){
        when(randomNumberGenerator.nextInt()).thenReturn(0);

        Assert.assertNotNull(runsSelector.getRandomRunsForBowler());
    }

}
