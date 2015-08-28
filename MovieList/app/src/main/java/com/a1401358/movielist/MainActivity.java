package com.a1401358.movielist;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


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

    }
}
