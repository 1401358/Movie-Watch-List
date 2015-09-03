package com.a1401358.movielist.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a1401358.daos.MovieListDao;
import com.a1401358.model.Movie;
import com.a1401358.movielist.R;
import com.a1401358.movielist.adapters.MovieListAdapater;


public class MoviesFragment extends Fragment implements MovieListDao.OnMovieListChangeListener, View.OnClickListener {
    private MovieListAdapater movieListAdapater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movieListAdapater = new MovieListAdapater();
        ListView movieList = (ListView) view.findViewById(R.id.listView);
        view.findViewById(R.id.addItem).setOnClickListener(this);
        movieList.setAdapter(movieListAdapater);
    }

    @Override
    public void onMovieAdd(Movie movie) {
        if (movieListAdapater != null)
            movieListAdapater.addItem(movie);
    }

    @Override
    public void onMovieDelete(Movie movie) {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        MovieListDao.getInstance().setOnMovieListChangeListener(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        MovieListDao.getInstance().setOnMovieListChangeListener(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addItem:
                Movie movie = new Movie();
                movie.title = "Movie Title"+movieListAdapater.getCount();
                MovieListDao.getInstance().addMovie(movie);
                break;
        }
    }
}
