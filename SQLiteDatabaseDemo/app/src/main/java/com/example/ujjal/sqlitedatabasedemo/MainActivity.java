package com.example.ujjal.sqlitedatabasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyDBHelper myDBHelper;
    private EditText nameInput, ageInput, genderInput, idInput;
    private Button addDataBtn, displayDataBtn, updateDataBtn, deleteDataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDBHelper = new MyDBHelper(this);
        SQLiteDatabase sqLiteDatabase = myDBHelper.getWritableDatabase();

        nameInput = (EditText) findViewById(R.id.nameInput);
        ageInput = (EditText) findViewById(R.id.ageInput);
        genderInput = (EditText) findViewById(R.id.genderInput);
        idInput = (EditText) findViewById(R.id.idInput);
        addDataBtn = (Button) findViewById(R.id.addDataBtn);
        displayDataBtn = (Button) findViewById(R.id.displayDataBtn);
        updateDataBtn = (Button) findViewById(R.id.updateDataBtn);
        deleteDataBtn = (Button) findViewById(R.id.deleteDataBtn);

        addDataBtn.setOnClickListener(this);
        displayDataBtn.setOnClickListener(this);
        updateDataBtn.setOnClickListener(this);
        deleteDataBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameInput.getText().toString();
        String age = ageInput.getText().toString();
        String gender = genderInput.getText().toString();
        String id = idInput.getText().toString();

        if (v.getId() == R.id.addDataBtn){
            long rowId = myDBHelper.insertData(name, age, gender);
            if (rowId < 0){
                Toast.makeText(getApplicationContext(), "unsuccessful!!!", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(), "Row "+rowId+" is successfully inserted", Toast.LENGTH_LONG).show();
            }
        }

        if (v.getId() == R.id.displayDataBtn){
            Cursor cursor = myDBHelper.displayData();

            if (cursor.getCount() == 0){
                //thee is no data
                showData("Error", "No data found");
                return;
            }
                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext()){
                    stringBuffer.append("ID: " + cursor.getString(0) + "\n");
                    stringBuffer.append("Name: " + cursor.getString(1) + "\n");
                    stringBuffer.append("Age: " + cursor.getString(2) + "\n");
                    stringBuffer.append("Gender: " + cursor.getString(3) + "\n\n\n");
                }
                showData("ResultSet", stringBuffer.toString());
            }

            if(v.getId() == R.id.updateDataBtn){
                Boolean isUpdated = myDBHelper.updateData(id, name, age, gender);

                if (isUpdated == true){
                    Toast.makeText(getApplicationContext(), "Data is updated", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(), "Data is not updated", Toast.LENGTH_LONG).show();
                }
            }

            if(v.getId() == R.id.deleteDataBtn){
                int value = myDBHelper.deleteData(id);

                if (value > 0){
                    Toast.makeText(getApplicationContext(), "Data is deleted", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(getApplicationContext(), "Data is not deleted", Toast.LENGTH_LONG).show();
                }
            }
        }

    private void showData(String resultSet, String name) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(resultSet);
        builder.setMessage(name);
        builder.setCancelable(true);
        builder.show();
    }
}
