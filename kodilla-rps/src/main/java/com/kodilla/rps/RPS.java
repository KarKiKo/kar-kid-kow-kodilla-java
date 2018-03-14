package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RPS {

    int numberOfRounds;
    String nameOfPlayer;
    int yourResult;
    int computerResult;

    public void start(){
        System.out.println("Napisz w konsoli swoje imię");
        Scanner input1 = new Scanner(System.in);
        this.nameOfPlayer = input1.nextLine();
        System.out.println("Cześć " + this.nameOfPlayer + "\nPodaj liczbę rund, po których nastąpi zwycięstwo w grze");
        Scanner input2 = new Scanner(System.in);
        try
        {
            this.numberOfRounds =  input2.nextInt();
            System.out.println("W tej grze musisz wygrać " + this.numberOfRounds + " rundę/rund/rundy, aby odnieść zwycięstwo\n" );
        }
        catch(InputMismatchException e)
        {
            System.out.println("Podaj poprawnie liczbe rund");
        }
    }

    public void getInstruction() {
        System.out.println("Klawisze do obsługi gry:\n");
        System.out.println("klawisz 1 - zagranie \"kamień\",");
        System.out.println("klawisz 2 - zagranie \"papier\",");
        System.out.println("klawisz 3 - zagranie \"nożyce\",");
        System.out.println("klawisz x - zakończenie gry");
        System.out.println("klawisz n - uruchomienie gry od nowa");
    }

    public void coreGame(){
        boolean end = false;
        Random random = new Random();
        this.yourResult = 0;
        this.computerResult = 0;
        while(!end){
            System.out.println("Co wybierasz?");
            Scanner input3 = new Scanner(System.in);
            int yourChoice = input3.nextInt();
            int computerChoice = random.nextInt(3)+1;
            System.out.println("Twój wybór: " + yourChoice + " Wybór komputera: " + computerChoice);
            if (yourChoice == computerChoice) {
                System.out.println("Remis");
            }
            if ((yourChoice == 1 && computerChoice == 3) || (yourChoice == 2 && computerChoice == 1) ||
                    (yourChoice == 3 && computerChoice == 2)) {
                System.out.println("Wygrałeś");
                yourResult++;
            }
            if ((yourChoice == 1 && computerChoice == 2) || (yourChoice == 2 && computerChoice == 3) ||
                    (yourChoice == 3 && computerChoice == 1)) {
                System.out.println("Przegrałeś");
                computerResult++;
            }

            end = (computerResult==numberOfRounds)||(yourResult==numberOfRounds)? true : false;
        }
        if(computerResult == numberOfRounds) {
        System.out.println("Przegrałeś/aś całą grę");
    }
        if(yourResult == numberOfRounds)    {
        System.out.println("Wygrałaś/eś całą grę");
    }
        System.out.println("Co chcesz teraz zrobić?\nklawisz x - zakończenie gry\nklawisz n - uruchomienie gry od nowa\n");
        Scanner input4 = new Scanner(System.in);
        String endOrNextPlay = input4.next();
        System.out.println(endOrNextPlay);
        if (endOrNextPlay.equals("n")) {RPS rps2 = new RPS(); rps2.start();
            rps2.getInstruction();rps2.coreGame();}
        if (endOrNextPlay.equals("x")) {
            System.out.println("Koniec gry");
        }
    }
}
