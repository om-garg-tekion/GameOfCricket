package com.CricketGame.GameOfCricket.testServices;

import com.CricketGame.GameOfCricket.model.beans.Innings;
import com.CricketGame.GameOfCricket.repository.InningsRepository;
import com.CricketGame.GameOfCricket.service.dataAccessService.InningsService;
import com.CricketGame.GameOfCricket.utils.InningsServiceUtilsTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class InningsServiceTest {

    @Mock
    InningsRepository inningsRepository;

    @InjectMocks
    InningsService inningsService;

    private InningsServiceUtilsTest inningsServiceUtilsTest;

    @BeforeEach
    public void setUp(){
        inningsServiceUtilsTest = new InningsServiceUtilsTest();
    }

    @Test
    public void testSaveInnings(){
        when(inningsRepository.save(any(Innings.class))).thenReturn(inningsServiceUtilsTest.getInnings(1L, 1L));

        Assert.assertEquals(inningsServiceUtilsTest.getInnings(1L, 1L),
                inningsService.saveInnings(inningsServiceUtilsTest.getInnings(1L, 1L)));
    }

}
