package com.kodilla.sudoku;

public class EmptySudokuElement {
    SudokuElement sudokuElement;
    Integer possibleValue;

    public EmptySudokuElement(SudokuElement sudokuElement, Integer possibleValue) {
        this.sudokuElement = sudokuElement;
        this.possibleValue = possibleValue;
    }

    public SudokuElement getSudokuElement() {
        return sudokuElement;
    }

    public Integer getPossibleValue() {
        return possibleValue;
    }
}
