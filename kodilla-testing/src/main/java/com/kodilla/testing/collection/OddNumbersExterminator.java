package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public void exterminate(ArrayList<Integer> numbers) {
        List<Integer> resultList = new ArrayList<Integer>();
        if (numbers.isEmpty()) {
        } else {
            for (int temporary : numbers) {
                if(temporary % 2 == 0 && temporary !=0){
                   resultList.add(temporary);
                }
            }
            numbers.clear();
            for (int temporary2: resultList
                 ) {
                numbers.add(temporary2);
            }
        }
    }
}
