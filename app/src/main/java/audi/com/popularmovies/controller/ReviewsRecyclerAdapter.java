package audi.com.popularmovies.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import audi.com.popularmovies.R;
import audi.com.popularmovies.model.ReviewsResponse;
import audi.com.popularmovies.model.database.greenbot.Movie;

/**
 * Created by Audi on 14/09/16.
 */
public class ReviewsRecyclerAdapter extends RecyclerView.Adapter<ReviewsRecyclerAdapter.ReviewsViewHolder> {

    private Context context;
    private List<ReviewsResponse.Review> reviews;
    private OnItemClick onItemClick;

    public ReviewsRecyclerAdapter(Context context, List<ReviewsResponse.Review> reviews) {
        this.context = context;
        this.reviews = reviews;
    }

    public class ReviewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvReviewContent;
        private TextView tvAuthor;

        public ReviewsViewHolder(View itemView) {
            super(itemView);

            tvReviewContent = (TextView) itemView.findViewById(R.id.tvReviewSummary);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClick != null)
                onItemClick.onItemClick((Movie) view.getTag());
        }
    }

    @Override
    public ReviewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_review_layout, parent, false);
        return new ReviewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewsViewHolder holder, int position) {
        ReviewsResponse.Review review = reviews.get(position);
        holder.tvReviewContent.setText(review.getContent());
        holder.tvAuthor.setText(review.getAuthor());
        holder.itemView.setTag(review);
    }

    public void setOnItemClickListerner(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }


    @Override
    public int getItemCount() {
        return reviews.size();
    }


    public interface OnItemClick {
        void onItemClick(Movie movie);
    }
}
