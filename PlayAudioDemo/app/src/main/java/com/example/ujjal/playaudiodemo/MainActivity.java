package com.example.ujjal.playaudiodemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer welcomeTune;
    private Thread timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeTune = MediaPlayer.create(this, R.raw.splashsound);
        welcomeTune.start();

        timer = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        welcomeTune.release();
        finish();
    }
}
