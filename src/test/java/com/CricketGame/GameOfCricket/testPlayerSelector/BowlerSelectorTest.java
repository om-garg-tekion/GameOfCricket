package com.CricketGame.GameOfCricket.testPlayerSelector;

import com.CricketGame.GameOfCricket.service.playerSelector.BowlerSelector;
import com.CricketGame.GameOfCricket.service.singletonInstantiator.RandomNumberGenerator;
import com.CricketGame.GameOfCricket.utils.BatsmanSelectorUtilsTest;
import com.CricketGame.GameOfCricket.utils.BowlerSelectorUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BowlerSelectorTest {

    @Mock
    RandomNumberGenerator randomNumberGenerator;

    @InjectMocks
    BowlerSelector bowlerSelector;

    private BowlerSelectorUtilsTest bowlerSelectorUtilsTest;

    @BeforeEach
    public void setUp(){
        bowlerSelectorUtilsTest = new BowlerSelectorUtilsTest();
    }

    @Test
    public void testChooseBowler(){
        when(randomNumberGenerator.nextInt()).thenReturn(0);

        Assert.assertNotNull(bowlerSelector.chooseBowler(bowlerSelectorUtilsTest.getTeam(), Optional.empty()));
    }
}
