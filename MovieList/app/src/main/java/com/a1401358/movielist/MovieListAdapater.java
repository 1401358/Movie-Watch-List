package com.a1401358.movielist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.a1401358.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 8/28/2015.
 */
public class MovieListAdapater extends BaseAdapter {

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
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_layout, parent, false);
        }
        return convertView;
    }
}
