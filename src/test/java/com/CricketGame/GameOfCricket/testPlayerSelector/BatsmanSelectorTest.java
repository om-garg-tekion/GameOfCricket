package com.CricketGame.GameOfCricket.testPlayerSelector;

import com.CricketGame.GameOfCricket.service.playerSelector.BatsmanSelector;
import com.CricketGame.GameOfCricket.utils.BatsmanSelectorUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BatsmanSelectorTest {

    @Mock
    BatsmanSelector batsmanSelector;

    private BatsmanSelectorUtilsTest batsmanSelectorUtilsTest;

    @BeforeEach
    public void setUp(){
        batsmanSelectorUtilsTest = new BatsmanSelectorUtilsTest();
    }

    @Test
    public void testChooseBatsman(){
        Assert.assertNotNull(batsmanSelector.chooseBatsman(batsmanSelectorUtilsTest.getBatsmanList(), 0));
    }
}
