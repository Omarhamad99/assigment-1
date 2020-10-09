package com.example.firstassigment.module;

import java.util.List;

public interface IMoviesDa {
    public List<Movies> getMovieByTitile(String title);
    public List<Movies> getMovieByYear(int year);
    public List<Movies> getMovieByGenre(String g);
    public String[] getGenre();
    public String[] getyears();
}
