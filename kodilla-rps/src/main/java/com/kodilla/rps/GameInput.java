package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameInput {

    private Random random = new Random();
    private int yourChoice;
    private int computerChoice;

    public int doYourMove() {
        while (true) {
            Scanner yourMoveInput = new Scanner(System.in);
            try {
                yourChoice = yourMoveInput.nextInt();
                break;
            } catch (InputMismatchException e) {
                yourChoice = 4;
                break;
            }
        }
        return yourChoice;
    }
    public String translateYourMove(int moveInt){
        String translatedYourMove;
        switch(moveInt){
            case 1: translatedYourMove = "Kamień"; break;
            case 2: translatedYourMove = "Papier"; break;
            case 3: translatedYourMove = "Nożyce"; break;
            default: translatedYourMove = "Błędne zagranie, utrata punktu";
        }
        return translatedYourMove;
    }
    public int doComputerMove() {
        computerChoice = random.nextInt(3)+1;
        return computerChoice;
    }
    public String translateComputerMove(int computerChoiceInt) {
        String translatedComputerMove;
        switch(computerChoiceInt){
            case 1: translatedComputerMove = "Kamień"; break;
            case 2: translatedComputerMove = "Papier"; break;
            default: translatedComputerMove = "Nożyce"; break;
        }
        return translatedComputerMove;
    }
}
