package com.a1401358.movielist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.a1401358.model.Movie;
import com.a1401358.movielist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 8/28/2015.
 */
public class MovieListAdapater extends BaseAdapter implements View.OnClickListener {

    private List<Movie> movieList = new ArrayList<>();

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = movieList.get(position);
        if (convertView == null) {
            final ViewHolder movieHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
            movieHolder.title = (TextView) convertView.findViewById(R.id.title);
            movieHolder.director = (TextView) convertView.findViewById(R.id.director);
            movieHolder.genres = (TextView) convertView.findViewById(R.id.generes);
            movieHolder.actors = (TextView) convertView.findViewById(R.id.actors);
            movieHolder.delete = (TextView) convertView.findViewById(R.id.delete);
            movieHolder.shareEvent = (TextView) convertView.findViewById(R.id.creatEvent);
            convertView.setTag(movieHolder);
        }
        final ViewHolder movieHolder = (ViewHolder) convertView.getTag();
        movieHolder.title.setText(movie.title);
        movieHolder.director.setText(movie.director);
        movieHolder.genres.setText(movie.genres);
        movieHolder.actors.setText(movie.actors);

        movieHolder.shareEvent.setOnClickListener(this);
        movieHolder.delete.setOnClickListener(this);

        movieHolder.shareEvent.setTag(movie);
        movieHolder.delete.setTag(movie);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        Movie movie = (Movie) v.getTag();
        switch (v.getId()) {
            case R.id.creatEvent:
                if (onShowMovieEventDialog != null)
                    onShowMovieEventDialog.showDialog(movie);
                break;
            case R.id.delete:
                removeMovie(movie);
                break;
        }
    }

    private static class ViewHolder {
        private TextView title, director, genres, actors, delete, shareEvent;
    }

    public void addItem(Movie movie) {
        movieList.add(movie);
        notifyDataSetChanged();
    }

    public void removeMovie(Movie movie) {
        movieList.remove(movie);
        notifyDataSetChanged();
    }

    private OnShowMovieEventDialog onShowMovieEventDialog;

    public void setOnShowMovieEventDialog(OnShowMovieEventDialog onShowMovieEventDialog) {
        this.onShowMovieEventDialog = onShowMovieEventDialog;
    }


    public interface OnShowMovieEventDialog {
        public void showDialog(Movie movie);
    }
}
