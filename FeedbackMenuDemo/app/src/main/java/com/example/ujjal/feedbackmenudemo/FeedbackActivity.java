package com.example.ujjal.feedbackmenudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendBtn, clearBtn;
    private EditText nameEditText, feedbackEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        feedbackEditText = (EditText) findViewById(R.id.feedbackEditText);
        sendBtn = (Button) findViewById(R.id.sendBtn);
        clearBtn = (Button) findViewById(R.id.clearBtn);

        sendBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try{
            String name = nameEditText.getText().toString();
            String message = feedbackEditText.getText().toString();

            if (v.getId() == R.id.sendBtn) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"ujjal.0011@gmail.com", "ujjal.0011@yahoo.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                intent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\nMessage: " + message);

                startActivity(Intent.createChooser(intent, "Feedback with"));
            }

            if (v.getId() == R.id.clearBtn) {

                nameEditText.setText("");
                feedbackEditText.setText("");

            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), " Exception ", Toast.LENGTH_SHORT).show();
        }

    }
}
