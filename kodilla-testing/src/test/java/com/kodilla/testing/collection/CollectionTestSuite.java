package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class CollectionTestSuite {

    @Before
        public void before(){
        System.out.println("Begin of TestCase");
    }
    @After
        public void after(){
        System.out.println("End of TestCase");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList(){
    //Given
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
    //When
        OddNumbersExterminator oddList = new OddNumbersExterminator();
        oddList.exterminate(emptyList);
        System.out.println("Testing empty list");
    //Then
        Assert.assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
            ArrayList<Integer> normalList = new ArrayList<Integer>();
            Random variable = new Random();
            for(int i=0; i < 10; i++){
             normalList.add(variable.nextInt(100));
            }
        //When
            OddNumbersExterminator oddList = new OddNumbersExterminator();
            oddList.exterminate(normalList);
            System.out.println("Testing normal list");
        //Then
            int sum = 0;
            for (int temp: normalList
             ) {
            sum += (temp % 2);
            }
            Assert.assertEquals(sum,0);
    }
}
