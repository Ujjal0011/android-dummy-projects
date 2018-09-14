package com.example.ujjal.checkboxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox checkBoxMilk, checkBoxSugar, checkBoxWater;
    private Button orderBtn;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxMilk = (CheckBox) findViewById(R.id.chkBoxMilk);
        checkBoxSugar = (CheckBox) findViewById(R.id.chkBoxSugar);
        checkBoxWater = (CheckBox) findViewById(R.id.chkBoxWater);
        orderBtn = (Button) findViewById(R.id.orderBtn);
        result = (TextView) findViewById(R.id.result);

        orderBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        StringBuilder finalResult = new StringBuilder();

        if (checkBoxMilk.isChecked()) {
            String value = checkBoxMilk.getText().toString();
            finalResult.append(value + " is ordered " + "\n");
        }
        if (checkBoxSugar.isChecked()) {
            String value = checkBoxSugar.getText().toString();
            finalResult.append(value + " is ordered " + "\n");
        }
        if (checkBoxWater.isChecked()) {
            String value = checkBoxWater.getText().toString();
            finalResult.append(value + " is ordered " + "\n");
        }

        result.setText(finalResult);
    }
}
