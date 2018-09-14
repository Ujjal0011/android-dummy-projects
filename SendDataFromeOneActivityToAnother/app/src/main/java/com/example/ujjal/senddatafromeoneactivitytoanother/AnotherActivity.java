package com.example.ujjal.senddatafromeoneactivitytoanother;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);

        result = (TextView) findViewById(R.id.result);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String value = bundle.getString("tag");
            result.setText(value);
        }
    }
}
