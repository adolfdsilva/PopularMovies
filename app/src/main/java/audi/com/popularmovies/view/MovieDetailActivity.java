package audi.com.popularmovies.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import audi.com.popularmovies.MovieApplication;
import audi.com.popularmovies.R;
import audi.com.popularmovies.model.database.greenbot.Movie;
import audi.com.popularmovies.utils.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends BaseActivity {


    Movie movie;
    @BindView(R.id.ivBackDrop)
    ImageView ivBackDrop;
    @BindView(R.id.fFav)
    FloatingActionButton fFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        init();
        addDetailFrag();

        fFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieApplication.getSession().insertOrReplace(movie);
            }
        });
    }

    private void addDetailFrag() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.TWO_PLANE, false);
        bundle.putParcelable(Constants.MOVIE, movie);
        Fragment fragment = new MovieDetailFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fMovieDetail, fragment)
                .commit();
    }

    void init() {
        setUpToolBar("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movie = getIntent().getParcelableExtra(Constants.MOVIE);
        Picasso.with(this).load(Constants.BACKDROP_URL + movie.getBackdrop_path())
                .into(ivBackDrop);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle(movie.getOriginal_title());
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

    }
}
