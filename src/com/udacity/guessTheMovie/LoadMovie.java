package com.udacity.guessTheMovie;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

class LoadMovie {
    private ArrayList<String> movieList = new ArrayList<>();

    void loadMovieList(String pathToFile) {
        try {
            FileReader file = new FileReader(pathToFile);
            Scanner scan = new Scanner(file);
            try {
                while (scan.hasNextLine()) {
                    movieList.add(scan.nextLine());
                }
            } catch (NullPointerException e) {
                System.out.println("Null pointer error: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found error: " + e.getMessage());
        }
    }
    ArrayList<String> getMovieList() {
        return movieList;
    }
}
