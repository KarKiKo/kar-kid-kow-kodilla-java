package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        World populationInTheWorld = new World();
        //When
        BigDecimal peopleQuantity = new BigDecimal("347000000");
        //Then
        Assert.assertEquals(peopleQuantity, populationInTheWorld.getPeopleQuantity());
    }
}
