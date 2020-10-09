package com.example.firstassigment;

import com.example.firstassigment.module.IMoviesDa;
import com.example.firstassigment.module.MoviesDa;

public class MoviesFac {
    public IMoviesDa getModel(){
        // if statement to check the internet connection

        return new MoviesDa();
    }
}
