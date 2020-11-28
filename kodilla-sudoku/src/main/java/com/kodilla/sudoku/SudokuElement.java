package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuElement {

    /*
    public static int EMPTY = -1;
    private int value = EMPTY;

    public SudokuElement(int value) {
        this.value = value;
    }

    private int getValue() {
        return value;
    }

    private ArrayList<Integer> possibleValues = new ArrayList<>();

    public ArrayList<Integer> theList() {
        for (int i = 1; i <= 9; i++) {
            possibleValues.add(i);
            System.out.println("Dodaje liczbę nr " + i);
        }
        return possibleValues;
    }

     */

    private PossibleValues possibleValues = new PossibleValues();

    public ArrayList<Integer> getTheList() {
        return possibleValues.getPossibleValues();
    }

    public ArrayList<Integer> removeFromTheList(int x) {
        possibleValues.getPossibleValues().remove(x);

        return possibleValues.getPossibleValues();
    }
}
