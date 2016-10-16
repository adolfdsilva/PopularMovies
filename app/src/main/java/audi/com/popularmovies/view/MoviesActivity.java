package audi.com.popularmovies.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import audi.com.popularmovies.R;
import audi.com.popularmovies.model.database.greenbot.Movie;
import audi.com.popularmovies.utils.Constants;

public class MoviesActivity extends BaseActivity implements MovieListFragment.MovieListCallback {

    private TextView tvTitle;
    private boolean isTwoPlane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        init();

        if (isTwoPlane) {
            //set toggle button
            ((Switch) toolbar.findViewById(R.id.swMovies)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                    if (checked) {
                        tvTitle.setText(getString(R.string.text_top_movies));
                        ((MovieListFragment) getSupportFragmentManager().findFragmentById(R.id.fMovieList))
                                .loadMovies(Constants.TOP_MOVIES);
                    } else {
                        tvTitle.setText(getString(R.string.text_pop_movies));
                        ((MovieListFragment) getSupportFragmentManager().findFragmentById(R.id.fMovieList))
                                .loadMovies(Constants.POP_MOVIES);
                    }
                }
            });
        }
    }

    void init() {
        if (findViewById(R.id.fMovieDetail) != null) {
            isTwoPlane = true;
            setUpToolBar("");
            tvTitle = (TextView) toolbar.findViewById(R.id.tvTitle);
            tvTitle.setText(R.string.text_pop_movies);
        }
    }


    @Override
    public void onMovieSelected(Movie movie) {
        if (isTwoPlane) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.MOVIE, movie);
            Fragment fragment = new MovieDetailFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fMovieDetail, fragment, MovieDetailFragment.class.getSimpleName())
                    .commit();
        } else {
            Intent intent = new Intent(this, MovieDetailActivity.class);
            intent.putExtra(Constants.MOVIE, movie);
            startActivity(intent);
        }
    }
}
