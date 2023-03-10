package com.CricketGame.GameOfCricket.testResults;

import com.CricketGame.GameOfCricket.service.results.InningsResult;
import com.CricketGame.GameOfCricket.utils.FinalResultUtilsTest;
import com.CricketGame.GameOfCricket.utils.InningsResultUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class InningsResultTest {

    @Mock
    InningsResult inningsResult;

    private InningsResultUtilsTest inningsResultUtilsTest;

    @BeforeEach
    public void setUp(){
        inningsResultUtilsTest = new InningsResultUtilsTest();
    }

    @Test
    public void testGetNumberOfOverTaken(){
        Assert.assertEquals("3.2", inningsResult.getNumberOfOverTaken(inningsResultUtilsTest.getPlayer()));
    }

    @Test
    public void testGetTotalNumberOfOverPlayed(){
        Assert.assertEquals("5.0", inningsResult.getTotalNumberOfOverPlayed(inningsResultUtilsTest.getInnings()));
    }
}
