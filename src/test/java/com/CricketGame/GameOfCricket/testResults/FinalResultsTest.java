package com.CricketGame.GameOfCricket.testResults;

import com.CricketGame.GameOfCricket.service.results.FinalResult;
import com.CricketGame.GameOfCricket.utils.FinalResultUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FinalResultsTest {

    @Mock
    FinalResult finalResult;

    private FinalResultUtilsTest finalResultUtilsTest;

    @BeforeEach
    public void setUp(){
        finalResultUtilsTest = new FinalResultUtilsTest();
    }

    @Test
    public void testPrintFinalResul1(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        finalResult.printFinalResult(finalResultUtilsTest.getMatch("India1", 100,"India2", 101, 10));

        Assert.assertEquals("India2 won the match by 10 wickets.\n", outContent.toString());

    }

    @Test
    public void testPrintFinalResult2(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        finalResult.printFinalResult(finalResultUtilsTest.getMatch("India1", 101,"India2", 100, 10));

        Assert.assertEquals("India1 won the match by 10 wickets.\n", outContent.toString());
    }

    @Test
    public void testPrintFinalResult3(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        finalResult.printFinalResult(finalResultUtilsTest.getMatch("India1", 100,"India2", 100, 10));

        Assert.assertEquals("It's a tie between both the teams\n", outContent.toString());

    }
}
