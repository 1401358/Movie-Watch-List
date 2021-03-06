package com.a1401358.movielist.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a1401358.daos.MovieListDao;
import com.a1401358.model.Movie;
import com.a1401358.movielist.R;
import com.a1401358.movielist.adapters.MovieListAdapater;


public class MoviesFragment extends Fragment implements MovieListDao.OnMovieListChangeListener, View.OnClickListener, MovieListAdapater.OnShowMovieEventDialog {
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
        movieListAdapater.setOnShowMovieEventDialog(this);
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
        if (movieListAdapater != null)
            movieListAdapater.setOnShowMovieEventDialog(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addItem:
                confirmFireMissiles();
                break;
        }
    }

    public void confirmFireMissiles() {
        DialogFragment newFragment = new CreateMovieFragmet();
        newFragment.show(getChildFragmentManager(), "movie");
    }

    @Override
    public void showDialog(Movie movie) {
        Bundle movieBundle = new Bundle();
        movieBundle.putString("title", movie.title);
        movieBundle.putString("director", movie.director);
        movieBundle.putString("actors", movie.actors);
        movieBundle.putString("genres", movie.genres);
        DialogFragment newFragment = new CreateMovieEventFragmet();
        newFragment.setArguments(movieBundle);
        newFragment.show(getChildFragmentManager(), "event");
    }
}
