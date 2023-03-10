package com.CricketGame.GameOfCricket.testValidator;


import com.CricketGame.GameOfCricket.service.validator.BattingOrderNumberValidator;
import com.CricketGame.GameOfCricket.utils.BattingOrderNumberValidatorUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BattingOrderNumberValidatorTest {
    @Mock
    BattingOrderNumberValidator battingOrderNumberValidator;

    private BattingOrderNumberValidatorUtilsTest battingOrderNumberValidatorUtilsTest;

    @BeforeEach
    public void setUp(){
        battingOrderNumberValidatorUtilsTest = new BattingOrderNumberValidatorUtilsTest();
    }

    @Test
    public void testIsInSequence(){
        Assert.assertTrue(battingOrderNumberValidator.isInSequence(battingOrderNumberValidatorUtilsTest.getBattingOrderNumbers()));
    }

    @Test
    public void testIsValid(){

        Assert.assertFalse(battingOrderNumberValidator.isValid(battingOrderNumberValidatorUtilsTest.getTeam()));
    }
}
