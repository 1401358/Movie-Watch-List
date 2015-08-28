package sampleactivities.metropolia.org.movielist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
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
