package me.nazy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements MovieAdapter.MovieItemClickListener {
    private String TAG = HomeActivity.class.getSimpleName();

    private MovieAdapter mAdapter;
    private RecyclerView mMoviesList;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mMoviesList = findViewById(R.id.rv_movies);

        int columnCount = this.getResources().getInteger((R.integer.home_grid_column_count));
        GridLayoutManager layoutManager = new GridLayoutManager(HomeActivity.this, columnCount);
        mMoviesList.setLayoutManager(layoutManager);
        mMoviesList.setHasFixedSize(true);

        mAdapter = new MovieAdapter(100, this);
        mMoviesList.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sort) {
            Toast.makeText(HomeActivity.this, "Sort action item selected", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onMovieItemClick(int clickedMovieIndex) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = new Toast(HomeActivity.this);
        mToast.makeText(HomeActivity.this, "Movie Item clicked in list", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(HomeActivity.this, MovieDetailActivity.class);
        intent.putExtra("movie_details", clickedMovieIndex);
        startActivity(intent);
    }
}
