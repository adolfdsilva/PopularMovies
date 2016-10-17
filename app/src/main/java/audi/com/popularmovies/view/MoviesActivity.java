package audi.com.popularmovies.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import audi.com.popularmovies.MovieApplication;
import audi.com.popularmovies.R;
import audi.com.popularmovies.model.database.greenbot.DaoSession;
import audi.com.popularmovies.model.database.greenbot.Movie;
import audi.com.popularmovies.utils.Constants;

public class MoviesActivity extends BaseActivity implements MovieListFragment.MovieListCallback {

    private TextView tvTitle;
    private boolean isTwoPlane;
    private MenuItem fav;
    private Switch topOrpop;
    private boolean isFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        init();

        //set toggle button
        topOrpop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                toggleMovies(checked);
            }
        });
    }

    void init() {
        if (findViewById(R.id.fMovieDetail) != null) {
            isTwoPlane = true;
        }
        setUpToolBar("");
        tvTitle = (TextView) toolbar.findViewById(R.id.tvTitle);
        tvTitle.setText(R.string.text_pop_movies);
        topOrpop = ((Switch) toolbar.findViewById(R.id.swMovies));

        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.TWO_PLANE, isTwoPlane);
        Fragment fragment = new MovieListFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fMovieList, fragment, MovieListFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainactivity, menu);
        fav = menu.findItem(R.id.listFav);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == fav.getItemId()) {
            if (!isFavorite) {
                isFavorite = true;
                DaoSession daoSession = MovieApplication.getSession();
                List<Movie> movies = daoSession.loadAll(Movie.class);
                if (((MovieListFragment) getSupportFragmentManager().findFragmentById(R.id.fMovieList)).populateMovieList(movies)) {
                    tvTitle.setText(R.string.text_favorites);
                    fav.setIcon(R.drawable.ic_favorite_white_48dp);
                    fav.setChecked(true);
                } else
                    Toast.makeText(this, R.string.toast_no_fav, Toast.LENGTH_LONG).show();
            } else {
                isFavorite = false;
                fav.setIcon(R.drawable.ic_favorite_border_white_48dp);
                toggleMovies(topOrpop.isChecked());
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void toggleMovies(boolean top) {
        if (top) {
            tvTitle.setText(getString(R.string.text_top_movies));
            ((MovieListFragment) getSupportFragmentManager().findFragmentById(R.id.fMovieList))
                    .loadMovies(Constants.TOP_MOVIES);
        } else {
            tvTitle.setText(getString(R.string.text_pop_movies));
            ((MovieListFragment) getSupportFragmentManager().findFragmentById(R.id.fMovieList))
                    .loadMovies(Constants.POP_MOVIES);
        }
    }

    @Override
    public void onMovieSelected(Movie movie) {
        if (isTwoPlane) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.MOVIE, movie);
            bundle.putBoolean(Constants.TWO_PLANE, isTwoPlane);

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
