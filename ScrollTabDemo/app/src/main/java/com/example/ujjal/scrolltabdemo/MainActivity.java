package com.example.ujjal.scrolltabdemo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MainActivity extends FragmentActivity {

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        CustomAdapter customAdapter = new CustomAdapter(fragmentManager);
        pager.setAdapter(customAdapter);

    }
}

class CustomAdapter extends FragmentStatePagerAdapter{

    public CustomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if(position == 0){
            fragment = new FragmentOne();
        } else if(position == 1){
            fragment = new FragmentTwo();
        }else if(position == 2){
            fragment = new FragmentThree();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "Tab1";
        } else if (position == 1) {
            return "Tab2";
        } else if (position == 2) {
            return "Tab3";
        }
        return null;
    }
}
