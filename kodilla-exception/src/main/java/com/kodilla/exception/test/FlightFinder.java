package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("Wroclaw", true);
        flightMap.put("Warsaw", true);
        flightMap.put("Lodz", false);
        flightMap.put("Gdansk", true);
        flightMap.put("Poznan", true);

        if (flightMap.get(flight.getArrivalAirport()) == null || flightMap.get(flight.getDepartureAirport())==null){
            throw new RouteNotFoundException("Object was null");
        }

        if (flightMap.get(flight.getArrivalAirport()) && flightMap.get(flight.getDepartureAirport())){
            System.out.println("Flight was found");
        } else {
            throw new RouteNotFoundException("Airport is on the list and soon flight will be possible");
        }
    }
}
