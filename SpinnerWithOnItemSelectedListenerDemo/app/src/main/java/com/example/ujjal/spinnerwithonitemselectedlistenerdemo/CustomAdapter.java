package com.example.ujjal.spinnerwithonitemselectedlistenerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends BaseAdapter{

    private Context context;
    private int[] flags;
    private String[] countries;
    private String[] population;
    private LayoutInflater layoutInflater;

    public CustomAdapter(MainActivity mainActivity, int[] flags, String[] countries, String[] population) {
        this.context = context;
        this.flags = flags;
        this.countries = countries;
        this.population = population;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView != null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.sample_view, null, false);
        }

        ImageView imageView = convertView.findViewById(R.id.flagImg);
        imageView.setImageResource(flags[position]);

        TextView countryName = convertView.findViewById(R.id.countryName);
        countryName.setText(countries[position]);

        TextView countryPopulation = convertView.findViewById(R.id.population);
        countryName.setText(population[position]);

        return convertView;

    }
}
