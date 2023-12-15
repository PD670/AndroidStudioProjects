package com.example.project95;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button Si,Si2,Si3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Si=findViewById(R.id.button3);
      Si2=findViewById(R.id.button2);
      Si3=findViewById(R.id.button5);
      Si3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent I4=new Intent(MainActivity.this, MainActivity4.class);
              startActivity(I4);
          }
      });
        Si2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I3=new Intent(MainActivity.this, MainActivity3.class);
                startActivity(I3);
            }
        });
        Si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I2=new Intent(MainActivity.this, secondpage.class);
                startActivity(I2);
            }
        });
    }
}