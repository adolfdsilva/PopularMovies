package audi.com.popularmovies.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import audi.com.popularmovies.R;
import audi.com.popularmovies.model.TrailerResponse;

/**
 * Created by Audi on 14/09/16.
 */
public class TrailersRecyclerAdapter extends RecyclerView.Adapter<TrailersRecyclerAdapter.MoviesViewHolder> {

    private Context context;
    private List<TrailerResponse.Trailer> trailers;
    private OnItemClick onItemClick;

    public TrailersRecyclerAdapter(Context context, List<TrailerResponse.Trailer> trailers) {
        this.context = context;
        this.trailers = trailers;
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvTrailerName;

        public MoviesViewHolder(View itemView) {
            super(itemView);

            tvTrailerName = (TextView) itemView.findViewById(R.id.tvTrailerName);
            tvTrailerName.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClick != null)
                onItemClick.onItemClick((TrailerResponse.Trailer) view.getTag());
        }
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_trailer_layout, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        TrailerResponse.Trailer trailer = trailers.get(position);
        holder.tvTrailerName.setText(trailer.getName());
        holder.tvTrailerName.setTag(trailer);

    }

    public void setOnItemClickListerner(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }


    @Override
    public int getItemCount() {
        return trailers.size();
    }


    public interface OnItemClick {
        void onItemClick(TrailerResponse.Trailer trailer);
    }
}
