package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    void testGetLastLog() {
        //Given
        String logOne = " Number 1";
        String logTwo = " Number 2 ";
        //When
        Logger.INSTANCE.log(logOne);
        Logger.INSTANCE.log(logTwo);
        //Then
        Assert.assertEquals(logTwo, Logger.INSTANCE.getLastLog());

    }
}
