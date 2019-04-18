package com.example.rentmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper  extends SQLiteOpenHelper {




    public DatabaseHelper(Context context) {

        super(context,"Register.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     sqLiteDatabase.execSQL("Create table user(name text primary key, number text)");
     sqLiteDatabase.execSQL("Create table tenant(names text primary key ,numbers text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("drop table if exists user");//drops table if exists
        sqLiteDatabase.execSQL("drop table if exists tenant");//drops table if exists
    }
     //inserting in database of owners
    public Boolean insert( String name, String number ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("number",number);
        long ins = sqLiteDatabase.insert("user",null,contentValues);
        if(ins==-1) return false;
        else return true;


    }

    // checking if name exists of owners
    public Boolean checkmate(String name){
        SQLiteDatabase  sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from user where name =?",new String[]{name});
        if(cursor.getCount()>0) return false;
        else return true;

    }

    //inserting on tenants table;
    public Boolean inserts( String names, String numbers ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("names",names);
        contentValues.put("numbers",numbers);
        long ints = sqLiteDatabase.insert("tenant",null,contentValues);
        if(ints ==-1) return false;
        else return true;
    }

    // checking if name exists of tenants
    public Boolean checkmates(String names){
        SQLiteDatabase  sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from tenant where names =?",new String[]{names});
        if(cursor.getCount()>0) return false;
        else return true;

    }




}
