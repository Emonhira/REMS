package com.example.rentmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LandOwnerActv extends AppCompatActivity {
    EditText e1,e2,e3;
    DatabaseHelper sqLiteDatabase;
    Button Button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_owner_actv);

        sqLiteDatabase = new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.number);
        e3=(EditText)findViewById(R.id.cnumber);
        Button3=(Button)findViewById(R.id.register);
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "স্থান পূরণ করুন", Toast.LENGTH_SHORT).show();

                }

                else {
                    if (s2.equals(s3)) {
                        Boolean checkmate = sqLiteDatabase.checkmate(s1);
                        if (checkmate == true) {
                            Boolean insert = sqLiteDatabase.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "সাফল্যের সাথে নিবন্ধিত", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "নাম ইতিমধ্যে বিদ্যমান", Toast.LENGTH_SHORT).show();
                        }


                    }
                    //Toast.makeText(getApplicationContext(),"সংখ্যা মেলে না",Toast.LENGTH_SHORT).show();

                }
            }


        });

    }
}
