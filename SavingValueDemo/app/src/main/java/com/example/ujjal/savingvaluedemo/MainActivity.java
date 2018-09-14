package com.example.ujjal.savingvaluedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView result;
    private Button addBtn, subBtn;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        addBtn = (Button) findViewById(R.id.addBtn);
        subBtn = (Button) findViewById(R.id.subBtn);

        if (loadScore() != 0){
            result.setText("Score: " + loadScore());
        }

        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
    }

    private int loadScore() {

        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        int score = sharedPreferences.getInt("lastScore", 0);
        return score;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.addBtn){
            score += 10;
            result.setText("Score: " + score);

            saveScore(score);
        }
        else if(v.getId() == R.id.subBtn){
            score -= 10;
            result.setText("Score: " + score);

            saveScore(score);
        }
    }

    private void saveScore(int score) {
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastScore", score);
        editor.commit();
    }
}
