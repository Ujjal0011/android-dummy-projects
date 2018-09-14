package com.example.ujjal.playvideodemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView video;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String uri = "android.resource://" + getPackageName() + "/" + R.raw.my_video;
        video = (VideoView) findViewById(R.id.video);

        if (video != null) {
            video.setVideoURI(Uri.parse(uri));
            video.requestFocus();

            mediaController = new MediaController(this);
            video.setMediaController(mediaController);

            video.start();
        } else {
            Toast.makeText(getApplicationContext(), "video is null", Toast.LENGTH_SHORT).show();
        }
    }
}
