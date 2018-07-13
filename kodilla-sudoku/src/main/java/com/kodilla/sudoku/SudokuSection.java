package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuSection {
    private int minRow;
    private int maxRow;
    private int minCol;
    private int maxCol;
    private List<SudokuElement> sudokuSection = new ArrayList<>();

    public SudokuSection( int ongoingRow, int ongoingColumn) {
        if (ongoingRow <= 3) {
            this.minRow = 1;
            this.maxRow = 3;
        } else if (ongoingRow <= 6) {
            this.minRow = 4;
            this.maxRow = 6;
        } else {
            this.minRow = 7;
            this.maxRow = 9;
        }
        if (ongoingColumn <= 3) {
            this.minCol = 1;
            this.maxCol = 3;
        } else if (ongoingColumn <= 6) {
            this.minCol = 4;
            this.maxCol = 6;
        } else {
            this.minCol = 7;
            this.maxCol = 9;
        }
    }

    public List<SudokuElement> createSection(SudokuBoard sudokuBoard){
        for(int k = minRow; k <=maxRow; k++){
            for(int l=minCol;l<=maxCol; l++){
                sudokuSection.add(sudokuBoard.getSudokuElement(k,l));            }
        }
        return sudokuSection;
    }

    @Override
    public String toString() {
        return "SudokuSection{" +
                "minRow=" + minRow +
                ", maxRow=" + maxRow +
                ", minCol=" + minCol +
                ", maxCol=" + maxCol +
                ", sudokuSection=" + sudokuSection +
                '}';
    }
}
