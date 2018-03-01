package com.kodilla.good.patterns.challenges;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStoreMain {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> listOfMovies = movieStore.getMovies();

        String englishVersion = listOfMovies.entrySet().stream()
          .map(entry-> entry.getValue().get(1))
          .collect(Collectors.joining("!"));

        String polishVersion = listOfMovies.entrySet().stream()
          .map(entry -> entry.getValue().get(0))
          .collect(Collectors.joining("!"));

        System.out.println(englishVersion + "!");
        System.out.println(polishVersion + "!");

    }
}
