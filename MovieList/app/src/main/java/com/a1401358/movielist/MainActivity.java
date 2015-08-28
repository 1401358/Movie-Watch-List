package com.a1401358.movielist;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.a1401358.model.Movie;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private MovieListAdapater movieListAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMovieList();;
    }

    private void setUpMovieList(){
        movieListAdapater = new MovieListAdapater();
        ListView movieList = (ListView)findViewById(R.id.listView);
        movieList.setAdapter(movieListAdapater);
        movieListAdapater.addItems(getDummyData());

    }

    private List<Movie> getDummyData(){
        List<Movie> movies = new ArrayList<>();
        for (int i = 0;i<20;i++){
            Movie movie = new Movie();
            movie.title = "Movie Title "+i;
            movies.add(movie);
        }
        return movies;
    }
}
