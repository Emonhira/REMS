package com.example.rentmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class database2 extends SQLiteOpenHelper {

    public database2(Context context) {

        super(context,"TRegister.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table tenants(names text primary key, numbers text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tenant");//drops table if exists
        onCreate(db);
    }
    //inserting on tenants table;
    public Boolean inserts( String names, String numbers){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("names",names);
        contentValues.put("numbers",numbers);
        long ints = db.insertOrThrow("tenant",null,contentValues);
        if(ints==-1) return false;
        else return true;

    }


    // checking if name exists of tenants
    public Boolean checkmates(String names){
        SQLiteDatabase  db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tenant where names =?",new String[]{names});
        if(cursor.getCount()>0) return false;
        else return true;

    }








}
