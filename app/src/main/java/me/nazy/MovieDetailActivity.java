package me.nazy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    private TextView mMovieName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        mMovieName = (TextView) findViewById(R.id.tv_movie_name);
        Intent startingIntent = getIntent();
        // TODO: add a const for intent name and localize error message
        if (startingIntent.hasExtra("movie_details")) {
            mMovieName.setText(String.valueOf(startingIntent.getIntExtra("movie_details", 0)));
        } else {
            mMovieName.setText("Something went wrong");
        }
    }
}
