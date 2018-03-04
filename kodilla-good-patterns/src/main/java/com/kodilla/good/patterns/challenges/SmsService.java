package com.kodilla.good.patterns.challenges;

public class SmsService implements InformationService{

    public void inform (String userLogin){
        System.out.println("Sending SMS to " + userLogin);
    };
}
