package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main (String[] args){

        SimpleUser simpleUser = new SimpleUser("Karolina");

        String result = simpleUser.getUserName();

        if(result.equals("Karolina")) {
            System.out.println("Test is ok");
        } else {
            System.out.println("Error");
        }

        Calculator calculator = new Calculator();
        int a = 5;
        int b = 10;
        int addResult = a + b;
        int subResult = a - b;
        if(addResult == calculator.add(a,b) && subResult == calculator.subtract(a,b)) {
            System.out.println("Positive result of calculator testing");
        } else {
            System.out.println("Negative result of calculator testing");
        }

    }
}
