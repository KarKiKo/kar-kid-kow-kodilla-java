package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        System.out.println("First search\n");
        try {
            flightFinder.findFlight(new Flight("Bialystok", "Warsaw"));
        } catch (RouteNotFoundException e) {
            System.out.println("Unfortunately, flight was not found \n" + e);
        }
        System.out.println("\nSecond search\n");
        try {
            flightFinder.findFlight(new Flight("Lodz", "Warsaw"));
        } catch (RouteNotFoundException e) {
            System.out.println("Unfortunately, flight was not found \n" + e);
        }
        System.out.println("\nThird search\n");
        try {
            flightFinder.findFlight(new Flight("Wroclaw", "Warsaw"));
        } catch (RouteNotFoundException e) {
            System.out.println("Unfortunately, flight was not found \n" + e);
        }
    }
}
