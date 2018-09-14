package com.example.ujjal.listviewfilteringandsearchviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private String[] countries;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        countries = getResources().getStringArray(R.array.countries);
        searchView = (SearchView) findViewById(R.id.searchView);

        arrayAdapter = new ArrayAdapter<String>(
                MainActivity.this,
                R.layout.sample_view,
                R.id.textView,
                countries);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, countries[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        arrayAdapter.getFilter().filter(newText);
        return false;
    }
}
