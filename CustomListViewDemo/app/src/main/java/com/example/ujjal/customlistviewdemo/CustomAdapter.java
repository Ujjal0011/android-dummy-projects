package com.example.ujjal.customlistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] flags;
    String[] countries;
    Context context;
    private LayoutInflater layoutInflater;

    CustomAdapter(Context context, String[] countries, int[] flags) {
        this.context = context;
        this.countries = countries;
        this.flags = flags;
    }

    @Override
    public int getCount() {
        return countries.length;
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

        if(convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.sample_view, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.flagImg);
        TextView textView = (TextView) convertView.findViewById(R.id.countryName);

        imageView.setImageResource(flags[position]);
        textView.setText(countries[position]);

        return convertView;
    }
}
