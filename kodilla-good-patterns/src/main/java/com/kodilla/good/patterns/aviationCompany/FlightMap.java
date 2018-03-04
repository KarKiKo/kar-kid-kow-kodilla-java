package com.kodilla.good.patterns.aviationCompany;

import java.util.HashSet;

public class FlightMap {

    private final HashSet<Flight> flightMap = new HashSet<>();

    public FlightMap(){
        flightMap.add(new Flight("A","B"));
        flightMap.add(new Flight("A","C"));
        flightMap.add(new Flight("A","D"));
        flightMap.add(new Flight("B","D"));
        flightMap.add(new Flight("B","E"));
        flightMap.add(new Flight("C","A"));
        flightMap.add(new Flight("C","D"));
        flightMap.add(new Flight("D","E"));
        flightMap.add(new Flight("E","A"));
        flightMap.add(new Flight("E","C"));
    }

    public HashSet<Flight> getflightMap() {
    return new HashSet<>(flightMap);
    }

}
