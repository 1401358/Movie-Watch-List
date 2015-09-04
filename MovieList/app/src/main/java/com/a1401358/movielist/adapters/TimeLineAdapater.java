package com.a1401358.movielist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.a1401358.model.Event;
import com.a1401358.movielist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 8/28/2015.
 */
public class TimeLineAdapater extends BaseAdapter {

    private List<Event> movieList = new ArrayList<>();

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
        Event event = movieList.get(position);
        if (convertView == null) {
            final ViewHolder movieHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_event, parent, false);
            movieHolder.location = (TextView)convertView.findViewById(R.id.location);
            movieHolder.title = (TextView)convertView.findViewById(R.id.title);
            movieHolder.director = (TextView) convertView.findViewById(R.id.director);
            movieHolder.genres = (TextView) convertView.findViewById(R.id.generes);
            movieHolder.actors = (TextView) convertView.findViewById(R.id.actors);
            movieHolder.delete = (TextView) convertView.findViewById(R.id.delete);
            convertView.setTag(movieHolder);
        }
        final ViewHolder  movieHolder = (ViewHolder)convertView.getTag();
        movieHolder.location.setText(event.location);
        movieHolder.title.setText(event.movie.title);
        movieHolder.director.setText(event.movie.director);
        movieHolder.genres.setText(event.movie.genres);
        movieHolder.actors.setText(event.movie.actors);
        movieHolder.delete.setTag(event);
        movieHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeMovie((Event)v.getTag());
            }
        });
        return convertView;
    }

    private static class ViewHolder{
        private ImageView thumbnail,deleteIcon;
        private TextView location,title,director,genres,actors,delete;

    }


    public void removeMovie(Event event) {
        movieList.remove(event);
        notifyDataSetChanged();
    }

    public void addItems(List<Event> items){
        movieList.addAll(items);
        notifyDataSetChanged();

    }

    public void addItem(Event event){
        movieList.add(event);
        notifyDataSetChanged();
    }


}
