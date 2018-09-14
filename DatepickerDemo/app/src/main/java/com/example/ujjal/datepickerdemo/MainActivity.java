package com.example.ujjal.datepickerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView currentDate;
    private DatePicker datePicker;
    private Button selectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentDate = (TextView) findViewById(R.id.currentDate);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        selectBtn = (Button) findViewById(R.id.selectBtn);

        currentDate.setText(currentDate());

        selectBtn.setOnClickListener(this);
    }

    private String currentDate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(datePicker.getDayOfMonth() + "/");
        stringBuilder.append(datePicker.getMonth() + "/");
        stringBuilder.append(datePicker.getYear());

        return stringBuilder.toString();
    }

    @Override
    public void onClick(View view) {
        currentDate.setText(currentDate());
    }
}
