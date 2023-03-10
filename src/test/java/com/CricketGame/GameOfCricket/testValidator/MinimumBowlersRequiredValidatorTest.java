package com.CricketGame.GameOfCricket.testValidator;

import com.CricketGame.GameOfCricket.service.validator.MinimumBowlersRequirementValidator;
import com.CricketGame.GameOfCricket.utils.BattingOrderNumberValidatorUtilsTest;
import com.CricketGame.GameOfCricket.utils.MinimumBowlersRequiredValidatorUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MinimumBowlersRequiredValidatorTest {

    @Mock
    MinimumBowlersRequirementValidator minimumBowlersRequirementValidator;

    private MinimumBowlersRequiredValidatorUtilsTest minimumBowlersRequiredValidatorUtilsTest;

    @BeforeEach
    public void setUp(){
        minimumBowlersRequiredValidatorUtilsTest = new MinimumBowlersRequiredValidatorUtilsTest();
    }

    @Test
    public void testMinimumBowlerRequiredValidator(){
        Assert.assertFalse(minimumBowlersRequirementValidator.isValid(minimumBowlersRequiredValidatorUtilsTest.getTeam()));
    }
}
