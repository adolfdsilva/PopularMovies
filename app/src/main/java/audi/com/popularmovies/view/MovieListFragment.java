package audi.com.popularmovies.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import audi.com.popularmovies.R;
import audi.com.popularmovies.controller.MoviesRecyclerAdapter;
import audi.com.popularmovies.model.MovieResponse;
import audi.com.popularmovies.model.database.greenbot.Movie;
import audi.com.popularmovies.utils.Constants;

/**
 * Created by Audi on 12/10/16.
 */

public class MovieListFragment extends Fragment {

    View rootView;
    private RecyclerView rvMovies;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movies_list, container, false);

        init();
        loadMovies(Constants.POP_MOVIES);

        return rootView;
    }


    private void init() {
        rvMovies = (RecyclerView) rootView.findViewById(R.id.rvMovieList);
        rvMovies.setLayoutManager(new GridLayoutManager(rvMovies.getContext(), 2));
        rvMovies.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
    }

    private void loadMovies(String url) {
        Uri uri = Uri.parse(url)
                .buildUpon()
                .appendQueryParameter("api_key", getString(R.string.api_key)).build();

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.GET, uri.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Constants.debug("Json Response: " + response);
                MovieResponse movieResponse = new Gson().fromJson(response, MovieResponse.class);
                movieResponse(movieResponse.getResults());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Constants.debug("Json Response: " + error.getMessage());
            }
        });
        queue.add(request);
    }


    private void movieResponse(List<Movie> movies) {
        if (movies != null && movies.size() > 0) {
            MoviesRecyclerAdapter adapter = new MoviesRecyclerAdapter(getActivity(), movies);
            rvMovies.setAdapter(adapter);

            adapter.setOnItemClickListerner(new MoviesRecyclerAdapter.OnItemClick() {
                @Override
                public void onItemClick(Movie movie) {
                    Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                    intent.putExtra(Constants.MOVIE, movie);
                    startActivity(intent);
                }
            });
        }
    }

}
