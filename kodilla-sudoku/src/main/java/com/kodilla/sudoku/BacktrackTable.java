package com.kodilla.sudoku;

public class BacktrackTable {
    SudokuBoard clonedSudokuBoard;
    int row;
    int column;
    int guessedValue;

    public BacktrackTable(SudokuBoard clonedSudokuBoard, int row, int column, int guessedValue) {
        this.clonedSudokuBoard = clonedSudokuBoard;
        this.row = row;
        this.column = column;
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getClonedSudokuBoard() {
        return clonedSudokuBoard;
    }

    public void setClonedSudokuBoard(SudokuBoard clonedSudokuBoard) {
        this.clonedSudokuBoard = clonedSudokuBoard;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getGuessedValue() {
        return guessedValue;
    }

    public void setGuessedValue(int guessedValue) {
        this.guessedValue = guessedValue;
    }
}
