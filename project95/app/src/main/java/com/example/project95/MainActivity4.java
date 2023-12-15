package com.example.project95;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {
Button P1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        P1=findViewById(R.id.button6);
        P1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent V1=new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(V1);
            }
        });
    }
}