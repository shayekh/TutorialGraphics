package com.example.android.tutorialgraphics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sutherland=(Button)findViewById(R.id.sutherland);
        sutherland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Sutherland.class);
                startActivity(intent);
            }
        });
        Button lion=(Button)findViewById(R.id.lion);
        lion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity.this,Lion.class);
                startActivity(intent1);
            }
        });

    }

}
