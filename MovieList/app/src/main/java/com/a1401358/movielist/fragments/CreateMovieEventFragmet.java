package com.a1401358.movielist.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.a1401358.daos.MovieListDao;
import com.a1401358.model.Event;
import com.a1401358.model.Movie;
import com.a1401358.movielist.R;

public class CreateMovieEventFragmet extends DialogFragment {

    private EditText location;
    private Movie movie;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle  movieBundle = getArguments();
        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        movie = new Movie();
        movie.actors = movieBundle.getString("actors");
        movie.title = movieBundle.getString("title");
        movie.genres = movieBundle.getString("genres");
        movie.director = movieBundle.getString("director");
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.create_event_layout, null);
        location = (EditText)dialogView.findViewById(R.id.location);
        ((TextView)dialogView.findViewById(R.id.title)).setText(movie.title);
        ((TextView)dialogView.findViewById(R.id.director)).setText(movie.director);
        ((TextView)dialogView.findViewById(R.id.generes)).setText(movie.genres);
        ((TextView)dialogView.findViewById(R.id.actors)).setText(movie.actors);
        builder.setView(dialogView)
                // Add action buttons
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Event event =  new Event();
                        event.location = location.getText().toString();
                        event.movie = movie;
                        MovieListDao.getInstance().addEvent(event);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        CreateMovieEventFragmet.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }



}
