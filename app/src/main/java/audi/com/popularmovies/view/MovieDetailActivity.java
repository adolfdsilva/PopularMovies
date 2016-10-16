package audi.com.popularmovies.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import audi.com.popularmovies.R;
import audi.com.popularmovies.model.database.greenbot.Movie;
import audi.com.popularmovies.utils.Constants;

public class MovieDetailActivity extends BaseActivity {


    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movie = getIntent().getParcelableExtra(Constants.MOVIE);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.MOVIE, movie);


        Fragment fragment = new MovieDetailFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fMovieDetail, fragment)
                .commit();

    }
}
