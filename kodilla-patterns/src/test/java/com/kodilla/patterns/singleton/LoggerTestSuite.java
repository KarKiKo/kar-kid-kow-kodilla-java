package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void getLastLogTest(){
        //When
        Logger.getInstance().log("this is last log");
        //Given
        String lastLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("this is last log", lastLog);
    }
}
