package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String args[]){
        SecondChallenge secondChallenge = new SecondChallenge();
        System.out.println("First attempt");
        try {
            secondChallenge.probablyIWillThrowException(5,2);
            System.out.println("You have chosen right numbers\n");
        } catch (SecondChallengeException e){
            System.out.println("Something is wrong with your numbers\n");
        }
        System.out.println("Second attempt");
        try {
            secondChallenge.probablyIWillThrowException(1.5,2);
            System.out.println("You have chosen right numbers\n");
        } catch (SecondChallengeException e){
            System.out.println("Something is wrong with your numbers\n");
        }
    }
}
