package com.a1401358.movielist.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a1401358.daos.MovieListDao;
import com.a1401358.daos.MovieListDao.OnEventListChangeListener;
import com.a1401358.model.Event;
import com.a1401358.model.Movie;
import com.a1401358.movielist.R;
import com.a1401358.movielist.adapters.TimeLineAdapater;


public class TimeLineFragment extends Fragment implements OnEventListChangeListener,View.OnClickListener{
    TimeLineAdapater timeLineAdapater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        timeLineAdapater = new TimeLineAdapater();
        ListView movieList = (ListView) view.findViewById(R.id.listView);
        view.findViewById(R.id.addItem).setOnClickListener(this);
        movieList.setAdapter(timeLineAdapater);
    }

    @Override
    public void onEventAdd(Event event) {
        if (timeLineAdapater != null) {
            timeLineAdapater.addItem(event);
        }
    }

    @Override
    public void onEventDelete(Event event) {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        MovieListDao.getInstance().setOnEventListChangeListener(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        MovieListDao.getInstance().setOnEventListChangeListener(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addItem:
                Movie movie = new Movie();
                movie.title = "Movie Title"+timeLineAdapater.getCount();
                Event event = new Event();
                event.location = "Location "+timeLineAdapater.getCount();
                event.movie = movie;
                MovieListDao.getInstance().addEvent(event);
                break;
        }
    }
}
