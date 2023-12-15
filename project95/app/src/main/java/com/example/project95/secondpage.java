package com.example.project95;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondpage extends AppCompatActivity {
Button Si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        Si=findViewById(R.id.button);
        Si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I2=new Intent(secondpage.this,MainActivity.class);
                startActivity(I2);
            }
        });
    }
}