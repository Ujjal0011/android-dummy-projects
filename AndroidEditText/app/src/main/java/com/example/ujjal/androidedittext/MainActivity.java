package com.example.ujjal.androidedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText inputNumber1, inputNumber2;
    private Button addBtn, subBtn;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber1 = (EditText) findViewById(R.id.inputNumber1);
        inputNumber2 = (EditText) findViewById(R.id.inputNumber2);

        addBtn = (Button) findViewById(R.id.addBtn);
        subBtn = (Button) findViewById(R.id.subBtn);

        result = (TextView) findViewById(R.id.result);

        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            String number1 = inputNumber1.getText().toString();
            String number2 = inputNumber2.getText().toString();

            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            if(view.getId() == R.id.addBtn) {
                double sum = num1 + num2;
                result.setText("Result: " + sum);
            }

            if(view.getId() == R.id.subBtn) {
                double sub = num1 - num2;
                result.setText("Result: " + sub);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Please Enter Numbers", Toast.LENGTH_SHORT).show();
        }
    }
}
