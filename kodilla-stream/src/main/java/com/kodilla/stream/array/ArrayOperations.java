package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static Double getAverage(int[] numbers){

            IntStream.range(0, 20)
                .forEach(n -> System.out.println(numbers[n]));
            Double averageStream = IntStream.range(0,20)
                .map(n->numbers[n])
                .average()
                .getAsDouble();
            return averageStream;
    }


}
