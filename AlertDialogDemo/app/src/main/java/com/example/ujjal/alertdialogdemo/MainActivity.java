package com.example.ujjal.alertdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showBtn;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showBtn = (Button) findViewById(R.id.exitBtn);
        showBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        alertDialogBuilder = new AlertDialog.Builder(this);

        //set title
        alertDialogBuilder.setTitle("Alert Title");

        //set message
        alertDialogBuilder.setMessage("Do you want to Exit?");

        //set icon
        alertDialogBuilder.setIcon(R.drawable.question);

        alertDialogBuilder.setCancelable(false);

        //for option Yes button
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        //for option No button
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        //for option Cancel button
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancel pressed", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
