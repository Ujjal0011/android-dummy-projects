package com.example.ujjal.ratingbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {

    private RatingBar ratingBar;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        result = (TextView) findViewById(R.id.result);
        //result.setText("Value: " + ratingBar.getProgress());

        ratingBar.setOnRatingBarChangeListener(this);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float currentRating, boolean b) {
        result.setText("Value : " + currentRating);
    }
}
