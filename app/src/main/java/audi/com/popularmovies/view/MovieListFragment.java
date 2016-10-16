package audi.com.popularmovies.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import audi.com.popularmovies.MovieApplication;
import audi.com.popularmovies.R;
import audi.com.popularmovies.controller.MoviesRecyclerAdapter;
import audi.com.popularmovies.model.MovieResponse;
import audi.com.popularmovies.model.database.greenbot.DaoSession;
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
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private TextView tvTitle;
    private MoviesRecyclerAdapter adapter;
    private boolean isTwoPlane;
    private MovieListCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (MovieListCallback) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movies_list, container, false);
        ButterKnife.bind(this, rootView);
        init();

        loadMovieAdapter();
        loadMovies(Constants.POP_MOVIES);

        //set toggle button
        ((Switch) toolbar.findViewById(R.id.swMovies)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    tvTitle.setText(getString(R.string.text_top_movies));
                    loadMovies(Constants.TOP_MOVIES);
                } else {
                    tvTitle.setText(getString(R.string.text_pop_movies));
                    loadMovies(Constants.POP_MOVIES);
                }
            }
        });

        return rootView;
    }

    private void init() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        tvTitle = (TextView) toolbar.findViewById(R.id.tvTitle);
        tvTitle.setText(R.string.text_pop_movies);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.mainactivity, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.listFav) {
            DaoSession daoSession = MovieApplication.getSession();
            List<Movie> movies = daoSession.loadAll(Movie.class);
            if (populateMovieList(movies))
                tvTitle.setText(R.string.text_favorites);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void loadMovieAdapter() {
        rvMovies.setLayoutManager(new GridLayoutManager(rvMovies.getContext(), isTwoPlane ? 3 : 2));
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

    private boolean populateMovieList(List<Movie> movies) {
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
