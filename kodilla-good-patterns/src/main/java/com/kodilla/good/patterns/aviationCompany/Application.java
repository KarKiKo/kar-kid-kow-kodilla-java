package com.kodilla.good.patterns.aviationCompany;

public class Application {

    public static void main(String[] args) {
        FlightFinderProcessor findFlight = new FlightFinderProcessor();
        System.out.println("Search nr 1");
        findFlight.findFlightFromTo("D","B");
        System.out.println("\nSearch nr 2");
        findFlight.findFlightFromTo("A","B");
        System.out.println("\nSearch nr 3");
        findFlight.findFlightFromTo("B","A");
        System.out.println("\nSearch nr 4");
        findFlight.allFlightsFrom("A");
        System.out.println("\nSearch nr 5");
        findFlight.allFlightsTo("E");
    }
}
