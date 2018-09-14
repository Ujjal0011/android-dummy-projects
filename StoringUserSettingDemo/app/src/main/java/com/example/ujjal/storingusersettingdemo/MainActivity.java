package com.example.ujjal.storingusersettingdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        if (loadColor() != getResources().getColor(R.color.colorPrimary)) {
            linearLayout.setBackgroundColor(loadColor());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.red) {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorRed));
            storeColor(getResources().getColor(R.color.colorRed));
        }
        if (item.getItemId() == R.id.green) {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            storeColor(getResources().getColor(R.color.colorGreen));
        }
        if (item.getItemId() == R.id.yellow) {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorYellow));
            storeColor(getResources().getColor(R.color.colorYellow));
        }
        if (item.getItemId() == R.id.blue) {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            storeColor(getResources().getColor(R.color.colorBlue));
        }

        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color) {
        SharedPreferences sharedPreferences = getSharedPreferences("backgroundColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("myColor", color);
        editor.commit();
    }

    private int loadColor() {

        SharedPreferences sharedPreferences = getSharedPreferences("backgroundColor", Context.MODE_PRIVATE);
        int color = sharedPreferences.getInt("myColor", getResources().getColor(R.color.colorPrimary));
        return color;
    }
}

