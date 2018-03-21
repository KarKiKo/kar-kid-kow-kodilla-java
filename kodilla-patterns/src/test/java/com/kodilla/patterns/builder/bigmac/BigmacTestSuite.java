package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test

    public void testNewBigMac(){
        //Given
        Bigmac bigmac = new Bigmac.BigMacBuilder()
                .roll ("normal")
                .ingredients("bacon")
                .sauce("standard")
                .burgers(1)
                .ingredients("cheese")
                .ingredients("onion")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(3,howManyIngredients);
    }
}
