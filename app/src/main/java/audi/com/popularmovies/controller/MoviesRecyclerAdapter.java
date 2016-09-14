package audi.com.popularmovies.controller;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Audi on 14/09/16.
 */
public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.BaseViewHolder> {

    public static class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public BaseViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }
}
