package com.kodilla.sudoku;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuBoard extends Prototype{

    private List<SudokuRow> sudokuRows = new ArrayList<>();
    BacktrackTable backtrackTable;

    public SudokuBoard() {
        for (int i = 1; i < 10; i++) {
            sudokuRows.add(new SudokuRow());
        }
        this.backtrackTable = null;
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    public void printTheBoard(){
        String text = " ";
        for(int j=1; j<=9;j++){
            text+= " " +j;
        }
        System.out.println(text);
        for(int i=0; i<9;i++) {
            SudokuRow oneRow = getSudokuRows().get(i);
            String printedBoard = oneRow.getSudokuElements().stream()
                    .map(SudokuElement::toString)
                    .collect(Collectors.joining("|", i+1 +"|", "|"));
            System.out.println(printedBoard);
        }
    }

    public void setValueForOneField(int row, int column, int value) {
        getSudokuRows().get(row-1).getSudokuElements().get(column-1).setValue(value);
    }

    public void setValueForManyFields(String string) {
        String wynik1[] = null;
        wynik1 = string.split(",");
        for (int i=1; i<=wynik1.length; i++){
            int row = Integer.parseInt(String.valueOf(wynik1[i-1].charAt(0)));
            int col = Integer.parseInt(String.valueOf(wynik1[i-1].charAt(1)));
            int value = Integer.parseInt(String.valueOf(wynik1[i-1].charAt(2)));
            setValueForOneField(row, col, value);
        }
    }

    public int getValueForOneField(int row, int column) {
        return getSudokuRows().get(row-1).getSudokuElements().get(column-1).getValue();
    }

    public SudokuElement getSudokuElement(int row, int column) {
        return getSudokuRows().get(row-1).getSudokuElements().get(column-1);
    }

    public SudokuBoard deepCopyOfSudokuBoard() throws CloneNotSupportedException{
        SudokuBoard clonedSudokuBoard = (SudokuBoard)super.clone();
        clonedSudokuBoard.sudokuRows = new ArrayList<>();
        for (SudokuRow row: sudokuRows) {
            SudokuRow clonedSudokuRow = new SudokuRow();
            clonedSudokuRow.getSudokuElements().clear();
            for(SudokuElement sudokuElement : row.getSudokuElements()){
                SudokuElement clonedSudokuElement = new SudokuElement();
                clonedSudokuElement.setValue(sudokuElement.getValue());
                List<Integer> clonedPossibleValues = new ArrayList<>();
                for(Integer possibleValue : sudokuElement.getPossibleValues()) {
                    clonedPossibleValues.add(new Integer(possibleValue));
                    clonedSudokuElement.setPossibleValues(clonedPossibleValues);
                }
                clonedSudokuRow.getSudokuElements().add(clonedSudokuElement);
            }
            clonedSudokuBoard.getSudokuRows().add(clonedSudokuRow);
        }
        return clonedSudokuBoard;
    }

    public void guess(int row, int column, int guessedValue){
        setValueForOneField(row,column,guessedValue);
    }

    public void createAndSetBacktrackTable(int row, int column, int guessedValue){
        SudokuBoard clonedSudokuBoard = new SudokuBoard();
        try {
            clonedSudokuBoard = deepCopyOfSudokuBoard();
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }
        backtrackTable = new BacktrackTable(clonedSudokuBoard, row, column, guessedValue);
        setBacktrackTable(backtrackTable);
    }

    public SudokuBoard rollbackForNextGuess(SudokuBoard sudokuBoard){
        return sudokuBoard.getBacktrackTable().getClonedSudokuBoard();
    }

    public SudokuBoard rollbackForError(SudokuBoard sudokuBoard){
        int row = sudokuBoard.getBacktrackTable().getRow();
        int col = sudokuBoard.getBacktrackTable().getColumn();
        int guessedValue = sudokuBoard.getBacktrackTable().getGuessedValue();
        sudokuBoard = sudokuBoard.getBacktrackTable().getClonedSudokuBoard();
        List<Integer> possibleValuesToBeUpdated = sudokuBoard.getSudokuElement(row,
                col).getPossibleValues();
        int indexToBeRemoved = possibleValuesToBeUpdated.indexOf(guessedValue);
        possibleValuesToBeUpdated.remove(indexToBeRemoved);
        System.out.println("ERROR ROLLBACK");
        return sudokuBoard;
    }

    public ArrayDeque<EmptySudokuElement> createFifoOfEmptySudokuElements() {
        ArrayDeque<EmptySudokuElement> fifoOfEmptySudokuElements = new ArrayDeque<>();
        for (int k = 1; k <= 9; k++) {
            for (int l = 1; l <= 9; l++) {
                SudokuElement ongoingSudokuElement = getSudokuElement(k, l);
                if (ongoingSudokuElement.isEmpty()) {
                    for (Integer oneOfPossValue: ongoingSudokuElement.getPossibleValues()) {
                        SudokuElement emptySudokuElement = new SudokuElement(ongoingSudokuElement.getValue(),
                                k,l, ongoingSudokuElement.getPossibleValues());
                        fifoOfEmptySudokuElements.offer(new EmptySudokuElement(emptySudokuElement,oneOfPossValue));
                    }
                }
            }
        }
        return fifoOfEmptySudokuElements;
    }

    public BacktrackTable getBacktrackTable() {
        return backtrackTable;
    }

    public void setBacktrackTable(BacktrackTable backtrackTable) {
        this.backtrackTable = backtrackTable;
    }

}
