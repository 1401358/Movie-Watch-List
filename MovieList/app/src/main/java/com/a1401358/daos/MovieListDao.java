package com.a1401358.daos;

import com.a1401358.model.Event;
import com.a1401358.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieListDao {


    private static MovieListDao instance;

    public static MovieListDao getInstance() {
        if (instance == null) {
            instance = new MovieListDao();
        }
        return instance;
    }

    private MovieListDao() {

    }

    private List<Movie> movieList = new ArrayList<>();

    private List<Event> eventList = new ArrayList<>();

    public List<Event> getEventList() {
        return eventList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public interface OnMovieListChangeListener{
        public void onMovieAdd(Movie movie);
        public void onMovieDelete(Movie movie);
    }

    public interface OnEventListChangeListener{
        public void onEventAdd(Event event);
        public void onEventDelete(Event event);
    }


    private OnMovieListChangeListener onMovieListChangeListener;

    private OnEventListChangeListener onEventListChangeListener;

    public void setOnMovieListChangeListener(OnMovieListChangeListener onMovieListChangeListener){
        this.onMovieListChangeListener = onMovieListChangeListener;
    }

    public void setOnEventListChangeListener(OnEventListChangeListener onEventListChangeListener){
        this.onEventListChangeListener = onEventListChangeListener;
    }

    public void addMovie(Movie movie){
        movieList.add(movie);
        if(onMovieListChangeListener!=null){
            onMovieListChangeListener.onMovieAdd(movie);
        }
    }

    public void addEvent(Event event){
        eventList.add(event);
        if(onEventListChangeListener!=null){
            onEventListChangeListener.onEventAdd(event);
        }
    }

}
