package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrerequisitiesRetriever {

    public static int numberOfRounds;
    public static String nameOfPlayer;

    public void retrieveData(){

        System.out.println("Witaj w grze Papier, Nożyce, Kamień!\n\nJak masz na imię?");
        Scanner nameInput = new Scanner(System.in);
        nameOfPlayer = nameInput.nextLine();
        System.out.println("Cześć " + nameOfPlayer + "\nPo ilu wygranych rundach ma nastąpić zwycięstwo w grze?");
        while(true) {
            Scanner numberOfRoundsInput = new Scanner(System.in);
            try {
                numberOfRounds = numberOfRoundsInput.nextInt();
                System.out.println("Twoim przeciwnikiem w tej grze będzie wirtualny przeciwnik.\nKto pierwszy wygra "
                        + numberOfRounds + " rundę/rund/rundy, zwycięży cały pojedynek.\n");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Podaj poprawnie liczbę rund");
            }
        }
    }
}
