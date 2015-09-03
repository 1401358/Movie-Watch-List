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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_layout, parent, false);
            movieHolder.thumbnail = (ImageView)convertView.findViewById(R.id.thumbnail);
            movieHolder.title = (TextView)convertView.findViewById(R.id.title);
            convertView.setTag(movieHolder);
        }
        final ViewHolder  movieHolder = (ViewHolder)convertView.getTag();
        movieHolder.title.setText(event.location);
        return convertView;
    }

    private static class ViewHolder{
        private ImageView thumbnail,deleteIcon;
        private TextView title,director,genres,actors;

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
