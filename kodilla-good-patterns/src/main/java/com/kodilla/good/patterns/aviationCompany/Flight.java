package com.kodilla.good.patterns.aviationCompany;

public class Flight {

    private String departureAirpot;
    private String arrivalAirport;

    public Flight(String departureAirpot, String arrivalAirport) {
        this.departureAirpot = departureAirpot;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirpot() {
        return departureAirpot;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!departureAirpot.equals(flight.departureAirpot)) return false;
        return arrivalAirport.equals(flight.arrivalAirport);
    }

    @Override
    public int hashCode() {
        int result = departureAirpot.hashCode()+arrivalAirport.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureAirpot='" + departureAirpot + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                '}';
    }
}
