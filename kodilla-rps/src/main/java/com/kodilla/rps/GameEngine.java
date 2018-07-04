package com.kodilla.rps;

import java.util.Scanner;

public class GameEngine {

    private int yourResult=0;
    private int computerResult=0;
    private GameInput gameInput = new GameInput();

    public void coreGame(){
        boolean end = false;
        while(!end) {
            beginningOfTheRound();
            summaryOfTheRound();
            end = computerResult==PrerequisitiesRetriever.getNumberOfRounds()||yourResult==PrerequisitiesRetriever.getNumberOfRounds();
        }
        summaryOfTheGame();
        makeFinalDecision();
    }
    private void beginningOfTheRound(){
        System.out.println("  Bieżący wynik \n     " + PrerequisitiesRetriever.getNameOfPlayer() + ": " + yourResult +
                "\n     Twój przeciwnik: " + computerResult);
        System.out.println("\nCo wybierasz(1-Kamień, 2-Papier, 3-Nożyce)?");
    }
    private void summaryOfTheRound() {
        int yourChoice = gameInput.doYourMove();
        String translatedChoice = gameInput.translateYourMove(yourChoice);
        int computerChoice = gameInput.doComputerMove();
        String translatedComputerChoice = gameInput.translateComputerMove(computerChoice);
        System.out.println("Twój wybór: " + translatedChoice + "\nWybór komputera: " + translatedComputerChoice);
        if (yourChoice == computerChoice) {
            System.out.println("Remis\n");
        }
        if ((yourChoice == 1 && computerChoice == 3) || (yourChoice == 2 && computerChoice == 1) ||
                (yourChoice == 3 && computerChoice == 2)) {
            System.out.println("\nWygrałeś tą rundę\n");
            yourResult++;
        }
        if ((yourChoice == 1 && computerChoice == 2) || (yourChoice == 2 && computerChoice == 3) ||
                (yourChoice == 3 && computerChoice == 1) || (yourChoice != 1 && yourChoice != 2
                && yourChoice != 3)) {
            System.out.println("\nPrzegrałeś tą rundę\n");
            computerResult++;
        }
    }
    private void summaryOfTheGame() {
        if(computerResult == PrerequisitiesRetriever.getNumberOfRounds()) {
            System.out.println("Przegrałeś/aś całą grę\n");
        }
        if(yourResult == PrerequisitiesRetriever.getNumberOfRounds())    {
            System.out.println("Wygrałaś/eś całą grę\n");
        }
        System.out.println("Co chcesz teraz zrobić?\nklawisz x - zakończenie gry\nklawisz n - uruchomienie gry od nowa\n");
    }
    private void makeFinalDecision() {
        Scanner decisionInput = new Scanner(System.in);
        String endOrNextPlay = decisionInput.next();
        switch(endOrNextPlay) {
            case "n": new RPS().start();
            case "x": System.out.println("Koniec gry");
            default: //do nothing
        }
    }
}
