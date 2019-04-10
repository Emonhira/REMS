package com.example.rentmanagement;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3;
DatabaseHelper sqLiteDatabase;
Button button3;


    public Button button;
     public void land(){
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(MainActivity.this,LandOwnerActv.class);

                startActivity(x);

            }
        });

    }

    public Button button2;
    public void tent(){
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent y = new Intent(MainActivity.this,Tentspart.class);

                startActivity(y);

            }
        });

    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        land();
        tent();
        sqLiteDatabase = new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.number);
        e3=(EditText)findViewById(R.id.cnumber);
        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(MainActivity.this, OwnerPart.class);

                startActivity(z);

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "স্থান পূরণ করুন", Toast.LENGTH_SHORT).show();

                }

                else {
                    if(s2.equals(s3)){
                        boolean checkname = sqLiteDatabase.checkname(s1);
                        if(checkname==true){
                           boolean insert = sqLiteDatabase.insert(s1,s2);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"সাফল্যের সাথে নিবন্ধিত", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"নাম ইতিমধ্যে বিদ্যমান",Toast.LENGTH_SHORT).show();
                        }



                    }


                }










            }


            });
        }


         }




