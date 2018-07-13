package com.kodilla.sudoku;

import java.util.*;
import java.util.stream.Collectors;

public class SudokuGame {

    private boolean wasError = false;

    public SudokuGame() {
        int board = letsBegin();
        SudokuBoard sudokuBoard = chooseGame(board);
        if(board > 5) {
            prepareOwnBoard(sudokuBoard);
        }
        resolveSudokuByYourself(sudokuBoard);
    }
    public boolean finish(){
        return true;
    }
    public void resolveSudokuByYourself(SudokuBoard sudokuBoard){
        boolean end = false;
        while(!end){
            System.out.println("Wypełnij pole wpisując kolejno 3 cyfry np. 123, gdzie 1 oznacza rząd, 2 onacza kolumnę," +
                    "a 3 oznacza wprowadzaną wartość.\nJeżeli chcesz rozwiązać sudoku wpisz w konsoli: SUDOKU");
            Scanner input = new Scanner(System.in);
            String valueOfOneField = input.nextLine();
            if(valueOfOneField.equals("SUDOKU")){
                resolveSudoku(sudokuBoard);
                end = true;
            } else {
                sudokuBoard.setValueForManyFields(valueOfOneField);
                sudokuBoard.printTheBoard();
            }
        }
    }
    public SudokuBoard chooseGame(int board){
        SudokuBoard sudokuBoard = new SudokuBoard();
        if (board == 1) {
            sudokuBoard.setValueForManyFields("118,153,184,269,295,325,331,366,383,435,454,499," +
                    "519,541,562,594,612,673,723,747,776,788,791,811,849,927,958");
        } else if (board == 2) {
            sudokuBoard.setValueForManyFields("113,154,172,212,225,263,277,284,334,355,361,388," +
                    "423,456,479,497,524,548,567,626,665,674,682,717,752,768,776,829,843,885,892," +
                    "914,922,951,987");
        } else if (board == 3) {
            sudokuBoard.setValueForManyFields("137,178,194,219,223,254,277," +
                    "357,361,411,436,452,569,582,632,664,681,698,751,768," +
                    "785,792,813,865,914,925");
        } else if (board == 4) {
            sudokuBoard.setValueForManyFields("135,141,153,174,187,198" +
                    "229,237,244,311,461,496,528,534,555,573,589,626,648" +
                    "751,799,867,871,882,913,921,932,956,977");
        } else if(board == 5) {
            sudokuBoard.setValueForManyFields("131,158,172,193,225,239,242,287," +
                    "317,467,481,519,523,532,551,578,643,699,795," +
                    "815,848,869,877,886,918,936,954,979");
        } else if (board > 5) {
            System.out.println("Wybrałes pustą planszę do samodzielnego wypełnienia");
        }
        sudokuBoard.printTheBoard();
        return sudokuBoard;
    }

    public void prepareOwnBoard(SudokuBoard sudokuBoard){
        System.out.println("Wprowadź String'a, który następnie wypełni Twoją planszę.\n" +
                "Przykład poprawnego wprowadzenia danych: \"112,145,247,568\". \n" +
                        "Każda 3-ka cyfr oznacza kolejno nr. wiersza, nr. kolumny oraz wartość," +
                        "która ma być wprowadzona. \nPamiętaj, aby każdą 3-kę cyfr rozdzielić przecinkiem.");
        Scanner nameInput = new Scanner(System.in);
        String boardPreparation = nameInput.nextLine();
        sudokuBoard.setValueForManyFields(boardPreparation);
        sudokuBoard.printTheBoard();
    }

    public int letsBegin(){
        System.out.println("Witaj w grze Sudoku!\n\nWybierz planszę, którą chciałbyś dzisiaj rozwiązać...\n" +
                "Wybierając cyfrę od 1 do 5 otrzymasz jedno z przygotowanych wcześniej plansz. Jeżeli chcesz samodzielnie" +
                "stworzyć planszę wybierz cyfrę 6.");
        Scanner input = new Scanner(System.in);
        int board = input.nextInt();
        return board;
    }

    public void resolveSudoku(SudokuBoard sudokuBoard) {
        boolean end = false;
        int guessCounter = 0;
        int whileCounter = 0;
        ArrayDeque<EmptySudokuElement> ongoingMapOfEmptyElements = new ArrayDeque<>();
        while (!end) {
            whileCounter++;
            int sumBegin = calculateValueOfAlllBoardElements(sudokuBoard);
            for (int k = 1; k <= 9; k++) {
                for (int l = 1; l <= 9; l++) {
                    SudokuElement ongoingSudokuElement = sudokuBoard.getSudokuElement(k, l);
                    if (ongoingSudokuElement.isEmpty()) {
                        lookForSolution(sudokuBoard, ongoingSudokuElement, k, l);
                    }
                }
            }
            int sumEnd = calculateValueOfAlllBoardElements(sudokuBoard);
            if (sumEnd == 405) {
                end = true;
            } else if (sumBegin - sumEnd != 0) {
            } else if ((guessCounter == 0) && (ongoingMapOfEmptyElements.size() == 0)) {
                guessCounter++;
                ongoingMapOfEmptyElements = sudokuBoard.createFifoOfEmptySudokuElements();
                EmptySudokuElement temporarySudokuElement = ongoingMapOfEmptyElements.poll();
                sudokuBoard.createAndSetBacktrackTable(temporarySudokuElement.getSudokuElement().getRow(),
                        temporarySudokuElement.getSudokuElement().getColumn(), temporarySudokuElement.getPossibleValue());
                sudokuBoard.guess(temporarySudokuElement.getSudokuElement().getRow(),
                        temporarySudokuElement.getSudokuElement().getColumn(), temporarySudokuElement.getPossibleValue());
            } else if ((guessCounter > 0) && (ongoingMapOfEmptyElements.size() != 0)) {
                guessCounter++;
                if (wasError) {
                    SudokuBoard abc = sudokuBoard.rollbackForError(sudokuBoard);
                    sudokuBoard = abc;
                    wasError = false;
                } else {
                    SudokuBoard def = sudokuBoard.rollbackForNextGuess(sudokuBoard);
                    sudokuBoard = def;
                }
                EmptySudokuElement temporarySudokuElement = ongoingMapOfEmptyElements.poll();
                sudokuBoard.createAndSetBacktrackTable(temporarySudokuElement.getSudokuElement().getRow(),
                        temporarySudokuElement.getSudokuElement().getColumn(), temporarySudokuElement.getPossibleValue());
                sudokuBoard.guess(temporarySudokuElement.getSudokuElement().getRow(), temporarySudokuElement.getSudokuElement().getColumn(),
                        temporarySudokuElement.getPossibleValue());
            } else if (guessCounter > 0 && ongoingMapOfEmptyElements.size() == 0) {
                System.out.println("All empty Queue was checked and solution was not found!!! That was extremly hard sudoku");
                break;
            }
            System.out.println("Nr.Of Iteration: " + whileCounter);
            sudokuBoard.printTheBoard();
        }
        System.out.println("KONIEC");
    }

    public int calculateValueOfAlllBoardElements(SudokuBoard sudokuBoard) {
        return sudokuBoard.getSudokuRows().stream()
                .flatMap(s -> s.getSudokuElements().stream())
                .map(s -> s.getValue())
                .reduce(0, (sum, current) -> sum += current);
    }

    public void lookForSolution(SudokuBoard sudokuBoard, SudokuElement sudokuElement, int row, int column) {
        List<SudokuElement> wholeRow = sudokuBoard.getSudokuRows().get(row - 1).getSudokuElements();
        List<SudokuElement> wholeColumn = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            wholeColumn.add(sudokuBoard.getSudokuElement(i, column));
        }
        SudokuSection sudokuSection = new SudokuSection(row, column);
        List<SudokuElement> wholeSection = sudokuSection.createSection(sudokuBoard);
        List<SudokuElement> wholeRowColumnAndSection = new ArrayList<>();
        wholeRowColumnAndSection.addAll(wholeRow);
        wholeRowColumnAndSection.addAll(wholeColumn);
        wholeRowColumnAndSection.addAll(wholeSection);
        List<Integer> valuesOfRowColumnAndSection = returnAllValuesOfIncludedSudokuElements(wholeRowColumnAndSection);
        updateOfPossibleValuesOfOngoingSudokuElement(sudokuElement, valuesOfRowColumnAndSection);
        if ((sudokuElement.getPossibleValues().size() == 1) && !(valuesOfRowColumnAndSection.contains(sudokuElement.getPossibleValues().get(0)))) {
            sudokuElement.setValue(sudokuElement.getPossibleValues().get(0));
        } else if (proceedLookingSolutionThroughMissingPossibleValue(sudokuElement, wholeRow)) {
        } else if (proceedLookingSolutionThroughMissingPossibleValue(sudokuElement, wholeColumn)) {
        } else if (proceedLookingSolutionThroughMissingPossibleValue(sudokuElement, wholeSection)) {
        } else if (((sudokuElement.getPossibleValues().size() == 1 && valuesOfRowColumnAndSection.contains(sudokuElement.getPossibleValues().get(0)) ||
                (sudokuElement.getPossibleValues().size() == 0)))) {
            wasError = true;
        }
    }

    public boolean proceedLookingSolutionThroughMissingPossibleValue(SudokuElement sudokuElement, List<SudokuElement> allSudokuElementsOfRowColumnOrSection) {
        boolean foundSolution = false;
        List<Integer> possibleValuesOfRowColumnOrSection = allSudokuElementsOfRowColumnOrSection.stream()
                .flatMap(s -> s.getPossibleValues().stream())
                .collect(Collectors.toList());
        for (int i = 0; i < sudokuElement.getPossibleValues().size(); i++) {
            int valueToBeFound = sudokuElement.getPossibleValues().get(i);
            int indexToBeRemoved = possibleValuesOfRowColumnOrSection.indexOf(valueToBeFound);
            possibleValuesOfRowColumnOrSection.remove(indexToBeRemoved);
        }
        for (int i = 0; i < sudokuElement.getPossibleValues().size(); i++) {
            if (!possibleValuesOfRowColumnOrSection.contains(sudokuElement.getPossibleValues().get(i))) {
                sudokuElement.setValue(sudokuElement.getPossibleValues().get(i));
                foundSolution = true;
            } else {
                foundSolution = false;
            }
        }
        return foundSolution;
    }

    public List<Integer> returnAllValuesOfIncludedSudokuElements(List<SudokuElement> allSudokuElementsOfRowOrSection) {
        List<Integer> allValuesOfRowOrSection = new ArrayList<>();
        for (SudokuElement val : allSudokuElementsOfRowOrSection) {
            allValuesOfRowOrSection.add(val.getValue());
        }
        return allValuesOfRowOrSection;
    }

    public void updateOfPossibleValuesOfOngoingSudokuElement(SudokuElement sudokuElement, List<Integer> allValuesOfRowColumnOrSection) {
        int n = 1;
        while (n <= 9) {
                if (allValuesOfRowColumnOrSection.contains(n)) {
                    if (sudokuElement.getPossibleValues().contains(n)) {
                        sudokuElement.removeFromPossibleValues(n);
                    }
                }
            n++;
        }
    }
}
