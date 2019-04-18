package com.example.rentmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tenant extends AppCompatActivity {

    EditText et1,et2,et3;
    database2 db;
    Button registers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentspart);
        db = new database2(this);
        et1=(EditText)findViewById(R.id.tname);
        et2=(EditText)findViewById(R.id.tnumber);
        et3=(EditText)findViewById(R.id.ctnumber);
        registers=(Button)findViewById(R.id.registers);
        registers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = et1.getText().toString();
                String st2 = et2.getText().toString();
                String st3 = et3.getText().toString();
                if (st1.equals("") || st2.equals("") || st3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill up empty spaces", Toast.LENGTH_SHORT).show();
                }

                else {
                    if (st2.equals(st3)) {
                        Boolean checkmates = db.checkmates(st1);
                        if (checkmates == true) {
                            Boolean inserts = db.inserts(st1, st2);
                            if (inserts == true) {
                                Toast.makeText(getApplicationContext(), "Successfully registered", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Name already exists", Toast.LENGTH_SHORT).show();
                        }


                    }
                    //Toast.makeText(getApplicationContext(),"সংখ্যা মেলে না",Toast.LENGTH_SHORT).show();

                }
            }


        });

    }
}






