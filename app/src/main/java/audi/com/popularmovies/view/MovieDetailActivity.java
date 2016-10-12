package audi.com.popularmovies.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import audi.com.popularmovies.R;
import audi.com.popularmovies.model.Movie;
import audi.com.popularmovies.utils.Constants;

public class MovieDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        setUpToolBar("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        populateUI();
    }

    private void populateUI() {
        Movie movie = getIntent().getParcelableExtra(Constants.MOVIE);

        Picasso.with(this).load(Constants.BACKDROP_URL + movie.getBackdrop_path())
                .into((ImageView) findViewById(R.id.ivBackDrop));
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle(movie.getOriginal_title());
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));


        //Set Title And Desc
        ((TextView)findViewById(R.id.tvOrgTitle)).setText(movie.getOriginal_title());
        ((TextView)findViewById(R.id.tvRelDate)).setText(movie.getRelease_date());
        ((TextView)findViewById(R.id.tvRating)).setText(movie.getVote_average() + "/10");
        ((TextView)findViewById(R.id.tvOverview)).setText(movie.getOverview());

    }
}
