package com.udacity.guessTheMovie;

public class Main {
    static final int TOTAL_TRIES_AVAILABLE = 10;

    public static void main(String[] args) {
        LoadMovie loadMovie = new LoadMovie();
        loadMovie.loadMovieList("movies.txt");
        String pickedMovie = new PickMovieFromList().pickMovie(loadMovie.getMovieList());
        System.out.println("Hi!");
        System.out.println("Welcome to Movie Title Guessing Game.");
        System.out.println();
        new GuessTitleLetters().startGuessing(pickedMovie);
    }
}
