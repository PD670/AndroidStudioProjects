package com.example.project95;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
 Button Si2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
       Si2=findViewById(R.id.button4);
        Si2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I3=new Intent(MainActivity3.this,MainActivity.class);
                startActivity(I3);
            }
        });
    }
}