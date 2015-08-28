package sampleactivities.metropolia.org.movielist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Imran on 8/28/2015.
 */
public class MovieListAdapater extends BaseAdapter {
    @Override
    public int getCount() {
        return 20;
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

        if(convertView== null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_layout,parent,false);
        }
        return convertView;
    }
}
