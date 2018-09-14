package com.example.ujjal.datepickerdialogdemo;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showBtn;
    private TextView result;
    private DatePickerDialog datePickerDialog;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        showBtn = (Button) findViewById(R.id.showBtn);

        showBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        datePicker = new DatePicker(this);
        int currentYear = datePicker.getYear();
        int currentMonth = datePicker.getMonth();
        int currentDay = datePicker.getDayOfMonth();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                result.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }, currentYear, currentMonth, currentDay);
        datePickerDialog.show();
    }
}
