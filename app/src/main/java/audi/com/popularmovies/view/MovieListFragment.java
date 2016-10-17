package audi.com.popularmovies.view;

import android.content.Context;
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
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Audi on 12/10/16.
 */

public class MovieListFragment extends Fragment {

    private View rootView;
    @BindView(R.id.rvMovieList)
    RecyclerView rvMovies;

    private MoviesRecyclerAdapter adapter;
    private boolean isTwoPlane;
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
        ButterKnife.bind(this, rootView);
        isTwoPlane = getArguments().getBoolean(Constants.TWO_PLANE);

        loadMovieAdapter();
        loadMovies(Constants.POP_MOVIES);


        return rootView;
    }

    private void loadMovieAdapter() {
        double width = Constants.getScreenWidth(getActivity());
        rvMovies.setLayoutManager(new GridLayoutManager(rvMovies.getContext(), width >= 720 ? 3 : 2));
        rvMovies.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
        adapter = new MoviesRecyclerAdapter(getActivity(), null);
        adapter.setOnItemClickListerner(new MoviesRecyclerAdapter.OnItemClick() {
            @Override
            public void onItemClick(Movie movie) {
                callback.onMovieSelected(movie);
            }
        });
    }

    void loadMovies(String url) {
        Uri uri = Uri.parse(url)
                .buildUpon()
                .appendQueryParameter("api_key", getString(R.string.api_key)).build();

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.GET, uri.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Constants.debug("Json Response: " + response);
                MovieResponse movieResponse = new Gson().fromJson(response, MovieResponse.class);
                populateMovieList(movieResponse.getResults());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Constants.debug("Json Response: " + error.getMessage());
            }
        });
        queue.add(request);
    }

    boolean populateMovieList(List<Movie> movies) {
        if (movies != null && movies.size() > 0) {
            adapter.setMovies(movies);
            adapter.notifyDataSetChanged();
            rvMovies.setAdapter(adapter);
            return true;
        }
        return false;
    }


    interface MovieListCallback {
        void onMovieSelected(Movie movie);
    }
}
