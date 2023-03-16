package com.CricketGame.GameOfCricket.testFactory;

import com.CricketGame.GameOfCricket.service.dataAccessService.AllService;
import com.CricketGame.GameOfCricket.service.factory.PlayerFactory;
import com.CricketGame.GameOfCricket.utils.PlayerFactoryUtilsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PlayerFactoryTest {

    @Mock
    AllService allService;

    @InjectMocks
    PlayerFactory playerFactory;

    private PlayerFactoryUtilsTest playerFactoryUtilsTest;

    @BeforeEach
    public void setUp(){
        playerFactoryUtilsTest = new PlayerFactoryUtilsTest();
    }

//    @Test
//    public void createPlayerTest(){
//        Mockito.mockStatic(AllService.class);
//        when(AllService.playerService.findById(1L, 1L, 1L)).thenReturn(playerFactoryUtilsTest.getPlayer(new PlayerKey(1L, 1L, 1L)));
//
//        Mockito.mockStatic(PlayerFactory.class);
//        Player player = PlayerFactory.create(1L, 1L, 1L);
//
//        Assert.assertEquals(playerFactoryUtilsTest.getPlayer(new PlayerKey(1L, 1L, 1L)), player);
//    }
}
