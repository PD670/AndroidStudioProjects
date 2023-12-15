package com.example.project95;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity5 extends AppCompatActivity {
   Button Si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Si=findViewById(R.id.button7);
        Si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I2=new Intent(MainActivity5.this, MainActivity.class);
                startActivity(I2);
            }
        });
    }
}