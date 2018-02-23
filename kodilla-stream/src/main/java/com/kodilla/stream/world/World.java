package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class World {

    private final List<Continent> continents = new ArrayList<>();

    public World() {
        continents.add(new Continent("Europe"));
        continents.add(new Continent("Asia"));
        continents.add(new Continent("Africa"));
    }

    public List<Continent> getContinents() {
        return new ArrayList<>(continents);
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPopulation)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

}
