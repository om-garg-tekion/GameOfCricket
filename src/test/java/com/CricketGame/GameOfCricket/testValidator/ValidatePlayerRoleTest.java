package com.CricketGame.GameOfCricket.testValidator;

import com.CricketGame.GameOfCricket.service.validator.ValidatePlayerRole;
import com.CricketGame.GameOfCricket.utils.ValidatePlayerRoleUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ValidatePlayerRoleTest {

    @Mock
    ValidatePlayerRole validatePlayerRole;

    private ValidatePlayerRoleUtilsTest validatePlayerRoleUtilsTest;

    @BeforeEach
    public void setUp(){
        validatePlayerRoleUtilsTest = new ValidatePlayerRoleUtilsTest();
    }

    @Test
    public void testIsValid(){
        Assert.assertTrue(validatePlayerRole.isValid(validatePlayerRoleUtilsTest.getPlayerDto()));
    }

}
