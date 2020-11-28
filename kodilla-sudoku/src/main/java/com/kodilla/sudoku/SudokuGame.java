package com.kodilla.sudoku;

public class SudokuGame {

    public static void main(String[] args) {

        /*
        boolean gameFinished = false;
        while (!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();
        }

         */

        SudokuElement sudokuElement = new SudokuElement();

        System.out.println(sudokuElement.getTheList());
        sudokuElement.removeFromTheList(0);
        //System.out.println(sudokuElement.getTheList());

    }

    public boolean resolveSudoku() {
        boolean playAgain = true; // dodać odniesnie do przycisku na klawiaturze Scanner

        if (playAgain) {
            return true;
        } else {
            return false;
        }
    }
}
