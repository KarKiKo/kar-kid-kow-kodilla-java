package com.kodilla.good.patterns.aviationCompany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FlightFinderProcessor {

    public List<Flight> allFlightsFrom(String departureAirport) {
        FlightMap flightMap = new FlightMap();
        List<Flight> allFlightsFrom = flightMap.getFlightMap().stream()
                .filter(f -> f.getDepartureAirpot().equals(departureAirport))
                .collect(toList());
        System.out.println(allFlightsFrom);
        return allFlightsFrom;
    }

    public List<Flight> allFlightsTo(String arrivalAirport) {
        FlightMap flightMap = new FlightMap();
        List<Flight> allFlightsTo = flightMap.getFlightMap().stream()
                .filter(f -> f.getArrivalAirport().equals(arrivalAirport))
                .collect(toList());
        System.out.println(allFlightsTo);
        return allFlightsTo;

    }

    public static boolean findDirectFlight(String departureAirport, String arrivalAirport) {
        FlightMap flightMap = new FlightMap();
        boolean directFlightFound;
        List<Flight> directFlight = flightMap.getFlightMap().stream()
                .filter(f -> f.getDepartureAirpot().equals(departureAirport) &&
                        f.getArrivalAirport().equals(arrivalAirport))
                .collect(toList());
        if (directFlight.isEmpty()) {
            System.out.println("Direct flights are unavailable. We are looking for you indirect flights...");
            directFlightFound = false;
        } else {
            System.out.println("We have found direct flight for you");
            directFlightFound = true;
        }
        return directFlightFound;
    }

    public static void findIndirectFlight(String departureAirport, String arrivalAirport) {
        FlightMap flightMap = new FlightMap();
        List<Flight> indirectFlights = flightMap.getFlightMap().stream()
                .filter(indf -> indf.getDepartureAirpot().equals(departureAirport) ||
                        indf.getArrivalAirport().equals(arrivalAirport))
                .collect(toList());
        List<Flight> indirectFlightsList = new ArrayList<>();
        for (int i = 0; i < indirectFlights.size(); i++) {
            Flight flight1 = indirectFlights.get(i);
            for (int j = 0; j < indirectFlights.size(); j++) {
                Flight flight2 = indirectFlights.get(j);
                if (flight1.getDepartureAirpot().equals(flight2.getArrivalAirport())) {
                    indirectFlightsList.add(flight1);
                    indirectFlightsList.add(flight2);
                    System.out.println("We have found a flight with a change in " + flight1.getDepartureAirpot());
                }
            }
        }
        if (indirectFlightsList.isEmpty()) {
            String failMessage = "We are sorry but we could not find any direct or indirect flight for you";
            System.out.println(failMessage);
        }
    }

    public void findFlightFromTo(String departureAirport, String arrivalAirport){
        if(FlightFinderProcessor.findDirectFlight(departureAirport,arrivalAirport)==false){
            FlightFinderProcessor.findIndirectFlight(departureAirport, arrivalAirport);
             }
    }
}
