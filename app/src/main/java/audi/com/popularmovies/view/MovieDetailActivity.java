package audi.com.popularmovies.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import audi.com.popularmovies.MovieApplication;
import audi.com.popularmovies.R;
import audi.com.popularmovies.model.database.greenbot.Movie;
import audi.com.popularmovies.utils.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends BaseActivity {


    @BindView(R.id.tvOrgTitle)
    TextView tvOrgTitle;
    @BindView(R.id.tvRelDate)
    TextView tvRelDate;
    @BindView(R.id.tvRating)
    TextView tvRating;
    @BindView(R.id.tvOverview)
    TextView tvOverview;

    @BindView(R.id.ivBackDrop)
    ImageView ivBackDrop;

    @BindView(R.id.fFav)
    FloatingActionButton fFavorites;

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        setUpToolBar("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        populateUI();

        fFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieApplication.getSession().insert(movie);
            }
        });
    }

    private void populateUI() {
        movie = getIntent().getParcelableExtra(Constants.MOVIE);

        Picasso.with(this).load(Constants.BACKDROP_URL + movie.getBackdrop_path())
                .into(ivBackDrop);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle(movie.getOriginal_title());
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));


        //Set Title And Desc
        tvOrgTitle.setText(movie.getOriginal_title());
        tvRelDate.setText(movie.getRelease_date());
        tvRating.setText(movie.getVote_average() + "/10");
        tvOverview.setText(movie.getOverview());

    }
}
