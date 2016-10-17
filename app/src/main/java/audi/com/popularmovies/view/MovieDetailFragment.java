package audi.com.popularmovies.view;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import audi.com.popularmovies.MovieApplication;
import audi.com.popularmovies.R;
import audi.com.popularmovies.controller.ReviewsRecyclerAdapter;
import audi.com.popularmovies.controller.TrailersRecyclerAdapter;
import audi.com.popularmovies.model.ReviewsResponse;
import audi.com.popularmovies.model.TrailerResponse;
import audi.com.popularmovies.model.database.greenbot.Movie;
import audi.com.popularmovies.utils.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Audi on 15/10/16.
 */

public class MovieDetailFragment extends Fragment {

    View rootView;
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
    @BindView(R.id.rvTrailers)
    RecyclerView rvTrailers;
    @BindView(R.id.rvReviews)
    RecyclerView rvReviews;
    @BindView(R.id.tvReviews)
    TextView tvReviewText;
    @BindView(R.id.tvTrailers)
    TextView tvTrailerText;
    @BindView(R.id.fFav)
    FloatingActionButton fFavorites;


    Movie movie;
    private boolean isTwoPlane;
    private TrailersRecyclerAdapter trailersRecyclerAdapter;
    private ReviewsRecyclerAdapter reviewsRecyclerAdapter;
    private RequestQueue queue;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movies_detail, container, false);
        ButterKnife.bind(this, rootView);

        init();
        populateUI();

        fFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieApplication.getSession().insertOrReplace(movie);
                fFavorites.setSelected(true);
            }
        });

        return rootView;
    }

    private void init() {
        movie = getArguments().getParcelable(Constants.MOVIE);
        isTwoPlane = getArguments().getBoolean(Constants.TWO_PLANE);
        queue = Volley.newRequestQueue(getActivity());
        //setup trailer and recycler views
        rvTrailers.setLayoutManager(new LinearLayoutManager(rvTrailers.getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvTrailers.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
        rvReviews.setLayoutManager(new LinearLayoutManager(rvTrailers.getContext(), LinearLayoutManager.VERTICAL, false));
        rvReviews.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        fFavorites.setVisibility(isTwoPlane ? View.VISIBLE : View.GONE);
        fFavorites.setSelected(Constants.isFavorite(movie.getId()));
    }

    private void loadReviews() {
        Uri uri = Uri.parse(Constants.MOVIES)
                .buildUpon()
                .appendPath(movie.getId() + "")
                .appendPath("reviews")
                .appendQueryParameter("api_key", getString(R.string.api_key)).build();
        Constants.debug("Uri: " + uri.toString());
        StringRequest request = new StringRequest(Request.Method.GET, uri.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Constants.debug("Json Response: " + response);
                ReviewsResponse reviewsResponse = new Gson().fromJson(response, ReviewsResponse.class);
                populateReviews(reviewsResponse.getResults());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Constants.debug("Json Response: " + error.getMessage());
            }
        });
        queue.add(request);
    }

    private void loadTrailers() {
        Uri uri = Uri.parse(Constants.MOVIES)
                .buildUpon()
                .appendPath(movie.getId() + "")
                .appendPath("videos")
                .appendQueryParameter("api_key", getString(R.string.api_key)).build();
        Constants.debug("Uri: " + uri.toString());

        StringRequest request = new StringRequest(Request.Method.GET, uri.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Constants.debug("Json Response: " + response);
                TrailerResponse trailerResponse = new Gson().fromJson(response, TrailerResponse.class);
                populateTrailers(trailerResponse.getResults());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Constants.debug("Json Response: " + error.getMessage());
            }
        });
        queue.add(request);

    }

    private boolean populateTrailers(List<TrailerResponse.Trailer> trailers) {
        if (trailers != null && trailers.size() > 0) {
            tvTrailerText.setVisibility(View.VISIBLE);
            trailersRecyclerAdapter = new TrailersRecyclerAdapter(getActivity(), trailers);
            trailersRecyclerAdapter.notifyDataSetChanged();
            rvTrailers.setAdapter(trailersRecyclerAdapter);
            trailersRecyclerAdapter.setOnItemClickListerner(new TrailersRecyclerAdapter.OnItemClick() {
                @Override
                public void onItemClick(TrailerResponse.Trailer trailer) {
                    if (!TextUtils.isEmpty(trailer.getKey()))
                        watchYoutubeVideo(trailer.getKey());
                    else
                        Toast.makeText(getActivity(), R.string.toast_no_link_to_trailer, Toast.LENGTH_LONG).show();
                }
            });
            return true;
        }
        return false;
    }

    private boolean populateReviews(List<ReviewsResponse.Review> reviews) {
        if (reviews != null && reviews.size() > 0) {
            tvReviewText.setVisibility(View.VISIBLE);
            reviewsRecyclerAdapter = new ReviewsRecyclerAdapter(getActivity(), reviews);
            reviewsRecyclerAdapter.notifyDataSetChanged();
            rvReviews.setAdapter(reviewsRecyclerAdapter);
            return true;
        }
        return false;

    }

    public void populateUI() {
        if (isTwoPlane)
            Picasso.with(getActivity()).load(Constants.BACKDROP_URL + movie.getBackdrop_path())
                    .into(ivBackDrop);
        else
            ivBackDrop.setVisibility(View.GONE);

        //Set Title And Desc
        tvOrgTitle.setText(movie.getOriginal_title());
        tvRelDate.setText(movie.getRelease_date());
        tvRating.setText(movie.getVote_average() + "/10");
        tvOverview.setText(movie.getOverview());

        loadTrailers();
        loadReviews();

    }

    public void watchYoutubeVideo(String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}
