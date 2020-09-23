package com.udacity.guessTheMovie;

import java.util.ArrayList;

class PickMovieFromList {

    String pickMovie(ArrayList<String> listOfMoviesToPickFrom) {
        int random = (int) (Math.random() * listOfMoviesToPickFrom.size());
        return listOfMoviesToPickFrom.get(random);
    }
}
