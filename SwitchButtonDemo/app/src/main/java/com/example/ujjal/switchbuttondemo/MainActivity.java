package com.example.ujjal.switchbuttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch wifiSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiSwitch = (Switch) findViewById(R.id.wifiSwitch);

        wifiSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            Toast.makeText(this, "On", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Off", Toast.LENGTH_SHORT).show();
        }
    }
}
