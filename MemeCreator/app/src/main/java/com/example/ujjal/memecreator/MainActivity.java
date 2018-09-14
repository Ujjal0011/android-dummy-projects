package com.example.ujjal.memecreator;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements TopSectionFragment.TopSectionListener {

    private BottomPictureFragment bottomFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void createMeme(String top, String bottom) {
        BottomPictureFragment bottomFragment = (BottomPictureFragment) getSupportFragmentManager().findFragmentById(R.id.fragment4);
    }
}
