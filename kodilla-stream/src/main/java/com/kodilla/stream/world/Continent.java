package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Continent {

    String continent;
    private final List<Country> countries = new ArrayList<>();

    public Continent(final String continent) {
        if (continent=="Europe"){
        countries.add(new Country ("Poland", new BigDecimal("38000000")));
        countries.add(new Country ("Germany", new BigDecimal("82000000")));
        }
        if (continent=="Asia"){
        countries.add(new Country("Thailand",new BigDecimal("67000000")));
        countries.add(new Country("Malaysia",new BigDecimal("28000000")));
        }
        if (continent=="Africa"){
        countries.add(new Country("Egipt",new BigDecimal("97000000")));
        countries.add(new Country("Marocco",new BigDecimal("35000000")));
        }
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

}
