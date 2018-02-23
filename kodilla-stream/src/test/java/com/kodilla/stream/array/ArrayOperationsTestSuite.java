package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import static com.kodilla.stream.array.ArrayOperations.getAverage;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = new int[20];
        for (int i = 0; i < 20; i++)
        {
            numbers[i] = 12;
        };
        //When
        Double average = getAverage(numbers);
        //Then
        Assert.assertEquals(average, 12.0, 0);
    }
}


