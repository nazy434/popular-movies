package me.nazy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();
    private static final String TEMPORARY_MOVIE_NAME = "Temp Movie";

    private final MovieItemClickListener mOnClickListener;
    private int mMovieItems;

    public interface MovieItemClickListener {
        void onMovieItemClick(int clickedMovieIndex);
    }

    MovieAdapter(int movieItemsCount, MovieItemClickListener listener) {
        mMovieItems = movieItemsCount;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_item_movie, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        String movieName = TEMPORARY_MOVIE_NAME + " " + String.valueOf(position);
        holder.bind(movieName);
    }

    @Override
    public int getItemCount() {
        return mMovieItems;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView listItemMovieView;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemMovieView = itemView.findViewById(R.id.tv_item_movie_name);
            listItemMovieView.setOnClickListener(this);
        }

        void bind(String movieName) {
            listItemMovieView.setText(movieName);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onMovieItemClick(clickedPosition);
        }
    }
}
