package com.example.ujjal.zoomcontrolsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private ZoomControls zoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);
        zoomControls = (ZoomControls) findViewById(R.id.zoomControl);

        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Zoom in", Toast.LENGTH_SHORT).show();

                float x = image.getScaleX();
                float y = image.getScaleY();

                image.setScaleX((float)x + 1);
                image.setScaleY((float)y + 1);
            }
        });

        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Zoom out", Toast.LENGTH_SHORT).show();

                float x = image.getScaleX();
                float y = image.getScaleY();

//                if (x > 1 && y > 1) {
//                    image.setScaleX((float)x - 1);
//                    image.setScaleY((float)y - 1);
//                }

                image.setScaleX((float)x - 1);
                image.setScaleY((float)y - 1);
            }
        });
    }

}
