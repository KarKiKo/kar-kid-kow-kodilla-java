package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameInput {

    private Scanner yourMoveInput;
    private Random computermove;
    private String translatedMove;

    public int doYourMove() {
        int yourChoice;
        while (true) {
            yourMoveInput = new Scanner(System.in);
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
        switch(moveInt){
            case 1: translatedMove = "Kamień"; break;
            case 2: translatedMove = "Papier"; break;
            case 3: translatedMove = "Nożyce"; break;
            default: translatedMove = "Błędne zagranie, utrata punktu";
        }
        return translatedMove;
    }
}
