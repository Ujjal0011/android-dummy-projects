package com.example.ujjal.signinandupindbdemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyDBHelper myDBHelper;
    private EditText userNameInput, passwordInput;
    private Button loginBtn, signUpHereBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameInput = (EditText) findViewById(R.id.userNameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        signUpHereBtn = (Button) findViewById(R.id.signUpBtn);

        loginBtn.setOnClickListener(this);
        signUpHereBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String username = userNameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(v.getId() == R.id.loginBtn){
            Boolean result = myDBHelper.findPassword(username, password);

            if(result == true){
                Intent intent = new Intent(MainActivity.this, SuccessLoginActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(), "Username or Password don't match!", Toast.LENGTH_LONG).show();
            }
        }
        if(v.getId() == R.id.signUpHereBtn){
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}
