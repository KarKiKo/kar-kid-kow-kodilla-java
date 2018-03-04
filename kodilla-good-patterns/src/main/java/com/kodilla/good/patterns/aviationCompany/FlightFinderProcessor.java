package com.kodilla.good.patterns.aviationCompany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FlightFinderProcessor {

    public List<Flight> allFlightsFrom(String departureAirport){
        FlightMap flightMap = new FlightMap();
        List<Flight> allFlightsFrom = flightMap.getflightMap().stream()
                .filter(f->f.hashCode()-f.getArrivalAirport().hashCode()==departureAirport.hashCode())
                .collect(toList());
        System.out.println(allFlightsFrom);
        return allFlightsFrom;
    }

    public List<Flight> allFlightsTo(String arrivalAirport){
        FlightMap flightMap = new FlightMap();
        List<Flight> allFlightsTo = flightMap.getflightMap().stream()
                .filter(f->f.hashCode()-f.getDepartureAirpot().hashCode()==arrivalAirport.hashCode())
                .collect(toList());
        System.out.println(allFlightsTo);
        return allFlightsTo;

    }

    public void findFlightFromTo(String departureAirport, String arrivalAirport){
        FlightMap flightMap = new FlightMap();
        List<Flight> directFlight = flightMap.getflightMap().stream()
                .filter(f->f.getDepartureAirpot().equals(departureAirport)&&
                        f.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toList());
        if (directFlight.isEmpty()) {
            System.out.println("Direct flights are unavailable. We are looking for you indirect flights...");
            List<Flight> indirectFlights = flightMap.getflightMap().stream()
                    .filter(indf->indf.getDepartureAirpot().equals(departureAirport)||
                            indf.getArrivalAirport().equals(arrivalAirport))
                    .collect(toList());
            List<Flight> indirectFlightsList = new ArrayList<>();
            for(int i = 0; i<indirectFlights.size();i++){
                Flight flight1 = indirectFlights.get(i);
                for(int j=0; j<indirectFlights.size();j++){
                    Flight flight2 = indirectFlights.get(j);
                    if(flight1.getDepartureAirpot().equals(flight2.getArrivalAirport())){
                        indirectFlightsList.add(flight1);
                        indirectFlightsList.add(flight2);
                        System.out.println("We have found a flight with a change in " + flight1.getDepartureAirpot());
                    }
                }
            }
            if (indirectFlightsList.isEmpty()){
                String failMessage = "We are sorry but we could not find any direct or indirect flight for you";
                System.out.println(failMessage);
            }
        } else {
            System.out.println("We have found direct flight from you");
        }
    }
}
