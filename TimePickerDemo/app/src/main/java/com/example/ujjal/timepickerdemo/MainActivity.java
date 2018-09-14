package com.example.ujjal.timepickerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TimePicker timePicker;
    private TextView result;
    private Button showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        result = (TextView) findViewById(R.id.result);
        showBtn = (Button) findViewById(R.id.showBtn);

        showBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String time = timePicker.getCurrentHour() + " : " + timePicker.getCurrentMinute();
        result.setText(time);
    }
}
