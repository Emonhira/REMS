package com.example.rentmanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper  extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Register.db";
    public static final String TABLE_NAME="Register";
    public static final String COL_1= "Name";
    public static final String COL_2="Number";

    public DatabaseHelper(Context context) {

        super(context, , factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
