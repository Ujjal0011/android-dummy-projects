package com.mydomain.clockdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextClock textClock;
    private AnalogClock analogClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textClock = (TextClock) findViewById(R.id.textClock);
        analogClock = (AnalogClock) findViewById(R.id.analogClock);

        textClock.setOnClickListener(this);
        analogClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.analogClock) {
            Toast.makeText(this, "Analog Clock", Toast.LENGTH_SHORT).show();
        } if(v.getId() == R.id.textClock) {
            Toast.makeText(this, "Text Clock", Toast.LENGTH_SHORT).show();
        }

    }
}
