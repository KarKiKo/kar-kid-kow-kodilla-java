package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static com.kodilla.rps.PrerequisitiesRetriever.numberOfRounds;

public class GameEngine {

    private int yourResult=0;
    private int computerResult=0;
    private String computerChoiceInTheRound;
    private Random random = new Random();

    public void coreGame(){
        boolean end = false;
        while(!end) {
            System.out.println("  Bieżący wynik \n     " + PrerequisitiesRetriever.nameOfPlayer + ": " + yourResult +
                    "\n     Twój przeciwnik: " + computerResult);
            System.out.println("\nCo wybierasz(1-Kamień, 2-Papier, 3-Nożyce)?");
            GameInput gameInput = new GameInput();
            int yourChoice = gameInput.doYourMove();
            String translatedChoice = gameInput.translateYourMove(yourChoice);

            int computerChoice = random.nextInt(3)+1;
            switch(computerChoice){
                case 1: computerChoiceInTheRound = "Kamień"; break;
                case 2: computerChoiceInTheRound = "Papier"; break;
                default: computerChoiceInTheRound = "Nożyce"; break;
            }
            System.out.println("Twój wybór: " + translatedChoice + "\nWybór komputera: " + computerChoiceInTheRound);
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
            end = (computerResult==numberOfRounds)||(yourResult==numberOfRounds)? true : false;
        }
        if(computerResult == numberOfRounds) {
            System.out.println("Przegrałeś/aś całą grę\n");
        }
        if(yourResult == numberOfRounds)    {
            System.out.println("Wygrałaś/eś całą grę\n");
        }
        System.out.println("Co chcesz teraz zrobić?\nklawisz x - zakończenie gry\nklawisz n - uruchomienie gry od nowa\n");
        Scanner decisionInput = new Scanner(System.in);
        String endOrNextPlay = decisionInput.next();
        switch(endOrNextPlay) {
            case "n": new RPS().start();
            case "x": System.out.println("Koniec gry");
            default: //do nothing
        }
    }
}
