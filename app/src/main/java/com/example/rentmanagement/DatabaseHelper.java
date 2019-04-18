package com.example.rentmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper  extends SQLiteOpenHelper {
    //public static final String DATABASE_NAME="Register.db";



    public DatabaseHelper(Context context) {

        super(context,"Register.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     sqLiteDatabase.execSQL("Create table user(name text primary key, number text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("drop table if exists user");//drops table if exists

    }
     //inserting in database
    public Boolean insert( String name, String number ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("number",number);
        long ins = sqLiteDatabase.insert("user",null,contentValues);
        if(ins==-1) return false;
        else return true;

    }
    // checking if name exists
    public Boolean checkmate(String name){
        SQLiteDatabase  sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from user where name =?",new String[]{name});
        if(cursor.getCount()>0) return false;
        else return true;


    }



}
