package com.udacity.guessTheMovie;

import java.util.*;

class GuessTitleLetters {

    private int triesLeft = Main.TOTAL_TRIES_AVAILABLE;
    private PrintData printData = new PrintData();
    private Scanner scan = new Scanner(System.in);

    private Set<Character> goodLetters = new TreeSet<>();
    private Set<Character> badLetters = new TreeSet<>();
    private Set<Character> distinctLetterInTitile = new TreeSet<>();
    private ArrayList<Character> pickedMovieArray = new ArrayList<>();

    void startGuessing(String pickedMovie) {
        //counting letters to fill, excluding whitespaces
        for (int i = 0; i < pickedMovie.length(); i++) {
            pickedMovieArray.add(pickedMovie.charAt(i));
            if (pickedMovie.charAt(i) != ' ') {
                distinctLetterInTitile.add(pickedMovie.charAt(i));
            }
        }
        while (triesLeft > 0) {
            //starting main loop
            System.out.println("Tries left: " + triesLeft);
            System.out.print("You are guessing: ");
            printData.printData(goodLetters, pickedMovieArray);
            System.out.println("Type a letter of your choice and press enter: ");
            char enteredLetter = scan.next().charAt(0);

            // checking is correct letter has been entered
            if (checkIfGuessedCorrectLetter(enteredLetter)) {
                System.out.println("GOOD!");
                distinctLetterInTitile.remove(enteredLetter);
                System.out.print("Good letters given so far: ");
                printData.printData(goodLetters);
            } else {
                triesLeft--;
                System.out.println("WRONG!");
                if (triesLeft == 0){
                    System.out.println("_______________________");
                    System.out.println("       GAME OVER");
                    System.out.println("_______________________");
                    System.out.println();
                    System.out.println("Correct answer was: " + pickedMovie.toUpperCase());
                } else {
                    System.out.print("Wrong letters given so far: ");
                    printData.printData(badLetters);
                }
            }
            if (distinctLetterInTitile.isEmpty()) {
                System.out.println();
                System.out.println("_______________________");
                System.out.println("GOOD you guessed it all");
                System.out.println("The answer is: " + pickedMovie.toUpperCase());
                System.out.println("_______________________");
                break;
            }
        }
    }
    // check if entered letter exists in the picked title
    private boolean checkIfGuessedCorrectLetter(char c) {
        for (Character inArrayChar : pickedMovieArray) {
            if (inArrayChar.equals(c)) {
                goodLetters.add(c);
                return true;
            }
        }
        badLetters.add(c);
        return false;
    }
}

