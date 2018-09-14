package com.example.ujjal.signinandupindbdemo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    MyDBHelper myDBHelper;
    private EditText nameSignUp, emailSignUp, userNameSignUp, passwordSignUp;
    private Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myDBHelper = new MyDBHelper(this);
        SQLiteDatabase sqLiteDatabase = myDBHelper.getWritableDatabase();

        nameSignUp = (EditText) findViewById(R.id.nameSignUp);
        emailSignUp = (EditText) findViewById(R.id.emailSignUp);
        userNameSignUp = (EditText) findViewById(R.id.userNameSignUp);
        passwordSignUp = (EditText) findViewById(R.id.passwordSignUp);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);

        signUpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = nameSignUp.getText().toString();
        String email = emailSignUp.getText().toString();
        String username = userNameSignUp.getText().toString();
        String password = passwordSignUp.getText().toString();

        if (v.getId() == R.id.signUpBtn){
            long rowId = myDBHelper.insertData(name, email, username, password);
            if (rowId < 0){
                Toast.makeText(getApplicationContext(), "unsuccessful!!!", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(), "Row "+rowId+" is successfully inserted", Toast.LENGTH_LONG).show();
            }
        }
    }
}
