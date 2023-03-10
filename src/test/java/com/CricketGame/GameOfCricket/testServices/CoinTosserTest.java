package com.CricketGame.GameOfCricket.testServices;


import com.CricketGame.GameOfCricket.model.enums.Coin;
import com.CricketGame.GameOfCricket.service.coinTosser.CoinTosser;
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
public class CoinTosserTest {

    @InjectMocks
    CoinTosser coinTosser;

    @Mock
    RandomNumberGenerator randomNumberGenerator;

    @Test
    public void testCoinTossing(){
        when(randomNumberGenerator.nextBoolean()).thenReturn(false);
        Assert.assertNotEquals(Coin.HEADS, coinTosser.flip());
    }

}
