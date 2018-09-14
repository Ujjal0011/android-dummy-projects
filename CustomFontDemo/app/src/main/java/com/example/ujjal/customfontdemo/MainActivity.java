package com.example.ujjal.customfontdemo;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result1, result2, result3;
    private Typeface typeface1, typeface2, typeface3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result1 = (TextView) findViewById(R.id.result1);
        result2 = (TextView) findViewById(R.id.result2);
        result3 = (TextView) findViewById(R.id.result3);

        typeface1 = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Bold.ttf");
        result1.setTypeface(typeface1);

        typeface2 = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Italic.ttf");
        result2.setTypeface(typeface2);

        typeface3 = Typeface.createFromAsset(getAssets(), "fonts/mitra.ttf");
        result3.setTypeface(typeface3);
    }
}
