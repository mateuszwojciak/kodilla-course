package com.kodilla.sudoku;

import java.util.ArrayList;

public class PossibleValues {
    private ArrayList<Integer> possibleValues = new ArrayList<>();

    private ArrayList<Integer> theList() {
        for (int i = 1; i <= 9; i++) {
            possibleValues.add(i);
            System.out.println("Dodaje liczbę nr " + i);
        }
        return possibleValues;
    }

    public ArrayList<Integer> getPossibleValues() {
        return theList();
    }
}
