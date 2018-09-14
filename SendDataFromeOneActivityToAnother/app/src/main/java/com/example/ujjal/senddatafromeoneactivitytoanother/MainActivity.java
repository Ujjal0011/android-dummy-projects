package com.example.ujjal.senddatafromeoneactivitytoanother;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button goBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goBtn = (Button) findViewById(R.id.goBtn);

        goBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent in = new Intent(this, AnotherActivity.class);
        in.putExtra("tag", "Bangladesh....");
        startActivity(in);
    }
}
