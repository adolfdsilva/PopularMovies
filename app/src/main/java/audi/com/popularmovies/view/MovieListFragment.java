package audi.com.popularmovies.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import audi.com.popularmovies.R;

/**
 * Created by Audi on 12/10/16.
 */

public class MovieListFragment extends Fragment {

    View rootView;
    private MovieListCallback callback;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (MovieListCallback) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movies_list, container, false);
        init();
        return rootView;
    }


    private void init() {
        RecyclerView rvMovies = (RecyclerView) rootView.findViewById(R.id.rvMovieList);
        callback.onListBind(rvMovies);
    }


    interface MovieListCallback {
        void onListBind(RecyclerView rvMovies);
    }
}
