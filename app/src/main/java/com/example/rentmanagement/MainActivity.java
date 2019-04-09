package com.example.rentmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3;
Button b3;















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
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.number);
        e3=(EditText)findViewById(R.id.cnumber);
        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(MainActivity.this,OwnerPart.class);

                startActivity(z);

            }
        });



    }
}
