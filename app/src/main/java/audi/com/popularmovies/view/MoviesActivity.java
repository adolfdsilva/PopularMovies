package audi.com.popularmovies.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import audi.com.popularmovies.R;
import audi.com.popularmovies.controller.MoviesRecyclerAdapter;
import audi.com.popularmovies.model.Movie;
import audi.com.popularmovies.model.MovieResponse;
import audi.com.popularmovies.utils.Constants;

public class MoviesActivity extends BaseActivity {

    private RecyclerView rvMovies;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        setUpToolBar("");

        init();
        loadMovies(Constants.POP_MOVIES);


        //set toggle button
        ((Switch)toolbar.findViewById(R.id.swMovies)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

    }

    private void init() {
        rvMovies = (RecyclerView) findViewById(R.id.rvMovieList);
        rvMovies.setLayoutManager(new GridLayoutManager(rvMovies.getContext(), 2));
        rvMovies.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));
        tvTitle = (TextView) toolbar.findViewById(R.id.tvTitle);

        tvTitle.setText(R.string.text_pop_movies);
    }

    private void loadMovies(String url) {
        Uri uri = Uri.parse(url)
                .buildUpon()
                .appendQueryParameter("api_key", getString(R.string.api_key)).build();

        RequestQueue queue = Volley.newRequestQueue(this);
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
            MoviesRecyclerAdapter adapter = new MoviesRecyclerAdapter(this, movies);
            rvMovies.setAdapter(adapter);

            adapter.setOnItemClickListerner(new MoviesRecyclerAdapter.OnItemClick() {
                @Override
                public void onItemClick(Movie movie) {
                    Intent intent = new Intent(getApplicationContext(), MovieDetailActivity.class);
                    intent.putExtra(Constants.MOVIE, movie);
                    startActivity(intent);
                }
            });
        }
    }
}
