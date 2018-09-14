package com.example.ujjal.radiobuttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroup;
    private RadioButton gender;
    private Button showBtn;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        showBtn = (Button) findViewById(R.id.showBtn);
        result = (TextView) findViewById(R.id.result);

        showBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        gender = (RadioButton) findViewById(selectedId);

        String value = gender.getText().toString();
        result.setText("You have selected: " + value);
    }
}
