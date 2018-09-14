package com.example.ujjal.customlistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] countries;
    private int[] flags = {R.drawable.bangladesh, R.drawable.nepal, R.drawable.bhutan,
            R.drawable.pakistan, R.drawable.usa, R.drawable.russia, R.drawable.finland,
            R.drawable.japan, R.drawable.india, R.drawable.canada, R.drawable.malta};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries = getResources().getStringArray(R.array.countries);
        listView = (ListView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this, countries, flags);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countries[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
