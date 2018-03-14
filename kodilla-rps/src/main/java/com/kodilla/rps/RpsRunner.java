package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        RPS rps = new RPS();
         rps.start();
         rps.getInstruction();
        rps.coreGame();

        /*Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        System.out.println(text);

        String imie; //w nim zapiszemy swoje imie
        Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od użytkownika

        imie = odczyt.nextLine();

        System.out.println("Witaj "+imie); //wyświetlamy powitanie*/

    }
}
