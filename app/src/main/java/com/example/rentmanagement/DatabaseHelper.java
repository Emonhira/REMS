package com.example.rentmanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper  extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Register.db";
    public static final String TABLE_NAME="Register";
    public static final String COL_1= "ID";
    public static final String COL_2="Name";
    public static final String COL_3="Number";

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     sqLiteDatabase.execSQL("CREATE TABLE" +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTO INCREMENT, Name TEXT, Number TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
