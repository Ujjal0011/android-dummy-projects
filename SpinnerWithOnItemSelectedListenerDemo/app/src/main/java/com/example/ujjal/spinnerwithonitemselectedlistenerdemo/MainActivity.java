package com.example.ujjal.spinnerwithonitemselectedlistenerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String[] countries;
    private String[] population;
    private int[] flags = {R.drawable.bangladesh, R.drawable.nepal, R.drawable.bhutan,
            R.drawable.pakistan, R.drawable.usa, R.drawable.russia, R.drawable.finland,
            R.drawable.japan, R.drawable.india, R.drawable.canada, R.drawable.malta};

    private CustomAdapter customAdapter;
    private boolean isFirstSelected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        countries = getResources().getStringArray(R.array.countries);
        population = getResources().getStringArray(R.array.population);

        customAdapter = new CustomAdapter(this, flags, countries, population);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isFirstSelected) {
                    isFirstSelected = false;
                } else {
                    Toast.makeText(getApplicationContext(), countries[position] + " is selected ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
