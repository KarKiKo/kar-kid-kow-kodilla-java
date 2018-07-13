package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    private int value;
    public static int EMPTY = -1;
    private List<Integer> possibleValues = new ArrayList<>();
    int row;
    int column;

    public SudokuElement() {
            this.value = EMPTY;
            for (int i=1; i<10; i++){
                possibleValues.add(i);
            }
    }
    public SudokuElement(int value, int row, int column, List<Integer> possibleValues){
        this.row = row;
        this.column = column;
        this.value = value;
        this.possibleValues = possibleValues;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        possibleValues.clear();
        possibleValues.add((Integer) value);
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    @Override
    public String toString() {
        if (getValue() == EMPTY){
            return " ";
        } else {
            return "" + value;
        }
    }

    public void removeFromPossibleValues(int value){
        int index = possibleValues.indexOf(value);
        possibleValues.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuElement that = (SudokuElement) o;

        if (value != that.value) return false;
        return possibleValues != null ? possibleValues.equals(that.possibleValues) : that.possibleValues == null;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isEmpty() {
        if (getValue() == -1) {
            return true;
        } else {
            return false;
        }
    }
}
