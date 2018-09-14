package com.example.ujjal.signinandupindbdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userdetails.db";
    private static final String TABLE_NAME = "user_details";
    private static final int VERSION_NUMBER = 1;
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), " + EMAIL + " VARCHAR(255), " + USERNAME + " VARCHAR(255),  " + PASSWORD + " VARCHAR(255));";

    private Context context;
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "onCreate is called", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            //e.printStackTrace();
            Toast.makeText(context, "Exception: " + e, Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context, "onCreate is called", Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Exception: " + e, Toast.LENGTH_LONG).show();
        }
    }

    public long insertData(String name, String email, String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(EMAIL, email);
        contentValues.put(USERNAME, username);
        contentValues.put(PASSWORD, password);

        long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return rowId;
    }

    public Cursor displayData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL, null);
        return cursor;
    }

//    public boolean updateData(String id, String name, String age, String gender) {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(ID, id);
//        contentValues.put(NAME, name);
//        contentValues.put(AGE, age);
//        contentValues.put(GENDER, gender);
//
//        sqLiteDatabase.update(TABLE_NAME, contentValues, ID + " = ?", new String[]{id});
//        return true;
//    }
//
//    public int deleteData(String id) {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        return sqLiteDatabase.delete(TABLE_NAME, ID + " = ?", new String[]{id});
//
//    }

    public Boolean findPassword(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        Boolean result = false;

        if(cursor.getCount() == 0){
            Toast.makeText(context, "No data is found!", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()){
                String usrName = cursor.getString(3);
                String pass = cursor.getString(4);

                if (username.equals(usrName) && password.equals(pass)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
