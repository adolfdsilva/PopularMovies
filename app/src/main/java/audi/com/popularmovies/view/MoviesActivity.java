package audi.com.popularmovies.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        rvMovies = (RecyclerView) findViewById(R.id.rvMovieList);
        rvMovies.setLayoutManager(new GridLayoutManager(rvMovies.getContext(), 2));
        rvMovies.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL_LIST));
        loadMovies();

    }

    private void loadMovies() {
        Uri uri = Uri.parse(Constants.POP_MOVIES)
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
                Constants.debug("Json Response: " + error.networkResponse.statusCode);
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
                    Intent intent = new Intent(getApplicationContext(),MovieDetailActivity.class);
                    intent.putExtra("movie",movie);
                    startActivity(intent);
                }
            });
        }
    }
}
