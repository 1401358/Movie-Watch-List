package com.a1401358.movielist.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.a1401358.daos.MovieListDao;
import com.a1401358.model.Movie;
import com.a1401358.movielist.R;

public class CreateMovieFragmet extends DialogFragment {

    private EditText movieTitle,director,genres,actors;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.create_movie_layout, null);
        movieTitle = (EditText)dialogView.findViewById(R.id.movieName);
        director = (EditText)dialogView.findViewById(R.id.director);
        genres = (EditText)dialogView.findViewById(R.id.genres);
        actors = (EditText)dialogView.findViewById(R.id.actors);
        builder.setView(dialogView)
                // Add action buttons
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Movie movie =  new Movie();
                        movie.title = movieTitle.getText().toString();
                        movie.director = director.getText().toString();
                        movie.genres = genres.getText().toString();
                        movie.actors = actors.getText().toString();
                        MovieListDao.getInstance().addMovie(movie);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        CreateMovieFragmet.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

}
