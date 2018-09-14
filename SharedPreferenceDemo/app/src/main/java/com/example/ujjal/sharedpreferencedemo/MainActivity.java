package com.example.ujjal.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView result;
    private EditText username, password;
    private Button saveBtn, loadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        loadBtn = (Button) findViewById(R.id.loadBtn);

        saveBtn.setOnClickListener(this);
        loadBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.saveBtn) {

            String user = username.getText().toString();
            String pass = password.getText().toString();

            if (user.equals("") && pass.equals("")) {
                Toast.makeText(getApplicationContext(), "Enter your data", Toast.LENGTH_SHORT).show();
            } else {

                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userNameKey", user);
                editor.putString("passwordKey", pass);
                editor.commit();
            }
        }

        if (v.getId() == R.id.loadBtn) {
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);

            if(sharedPreferences.contains("userNameKey") && sharedPreferences.contains("passwordKey")) {
                String user = sharedPreferences.getString("userNameKey", "Data Not Found!");
                String pass = sharedPreferences.getString("passwordKey", "Data Not Found!");
                result.setText(user + "\n" + pass);
            }

        }

    }
}
