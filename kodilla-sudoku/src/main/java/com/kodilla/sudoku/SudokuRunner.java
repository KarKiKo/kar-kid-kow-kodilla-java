package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SudokuRunner {
    public static void main(String args[]) {
        boolean gameFinished = false;
        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.finish();
        }
     }
}