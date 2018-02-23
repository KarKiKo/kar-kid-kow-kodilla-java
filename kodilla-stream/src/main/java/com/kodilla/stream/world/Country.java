package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final String country;
    private final BigDecimal population;

    public Country(String country, BigDecimal population) {
        this.country = country;
        this.population = population;
    }

    public BigDecimal getPopulation(){
        return population;
    }

    public String getCountry() {
        return country;
    }
}
