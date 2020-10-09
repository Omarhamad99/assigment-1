package com.example.firstassigment.module;

import java.util.ArrayList;
import java.util.List;

public class MoviesDa implements IMoviesDa{
    private ArrayList<Movies> movies = new ArrayList<>();
    public MoviesDa(){
        movies.add(new Movies("Harry potter",2010,"mystery"));
        movies.add(new Movies("Hobs and Show",2019,"Action"));
        movies.add(new Movies("21 Jump Street",2012,"Comedy"));
        movies.add(new Movies("Titanic",1997,"Romance"));
        movies.add(new Movies("The Conjuring 2",2016,"Horror"));
    }

    public List<Movies> getMovieByTitile(String title){
        ArrayList<Movies> res = new ArrayList<>();
        for (Movies m : movies){
            if(m.getTitle().equals(title) || m.getTitle().contains(title)){
                res.add(m);
            }
        }
        return res;
    }
    public List<Movies> getMovieByYear(int year){
        ArrayList<Movies> res = new ArrayList<>();
        for (Movies m : movies){
            if(m.getYear()==year){
                res.add(m);
            }
        }
        return res;
    }
    public List<Movies> getMovieByGenre(String g){
        ArrayList<Movies> res = new ArrayList<>();
        for (Movies m : movies){
            if(m.getGenre().equals(g)){
                res.add(m);
            }
        }
        return res;
    }
    public String[] getGenre() {
        String[] cats = new String[]{"mystery", "Action", "Comedy","Romance","Horror"};

        return cats;
    }
    public String[] getyears() {
        String[] cats = new String[]{"2010", "2019", "1997","2016","2012"};

        return cats;
    }
}
