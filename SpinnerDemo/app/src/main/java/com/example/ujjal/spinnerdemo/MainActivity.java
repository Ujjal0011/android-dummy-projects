package com.example.ujjal.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] countries;
    private Spinner spinner;
    private Button btn;
    private TextView result;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries = getResources().getStringArray(R.array.countries);
        spinner = (Spinner) findViewById(R.id.spinner);
        result = (TextView) findViewById(R.id.result);
        btn = (Button) findViewById(R.id.btn);

        arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.sample_view,
                R.id.sampleTextView,
                countries);
        spinner.setAdapter(arrayAdapter);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String value = spinner.getSelectedItem().toString();
        result.setText(value);
    }
}
