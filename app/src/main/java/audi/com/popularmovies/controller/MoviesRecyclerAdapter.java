package audi.com.popularmovies.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import audi.com.popularmovies.R;
import audi.com.popularmovies.model.database.greenbot.Movie;
import audi.com.popularmovies.utils.Constants;

/**
 * Created by Audi on 14/09/16.
 */
public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.MoviesViewHolder> {

    private Context context;
    private List<Movie> movies;
    private OnItemClick onItemClick;

    public MoviesRecyclerAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView ivCover;

        public MoviesViewHolder(View itemView) {
            super(itemView);

            ivCover = (ImageView) itemView.findViewById(R.id.ivCover);
            ivCover.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClick != null)
                onItemClick.onItemClick((Movie) view.getTag());
        }
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_movie_layout, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Picasso.with(context).load(Constants.POSTER_URL + movie.getPoster_path()).into(holder.ivCover);
        holder.ivCover.setTag(movie);

    }

    public void setOnItemClickListerner(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public interface OnItemClick {
        void onItemClick(Movie movie);
    }
}
