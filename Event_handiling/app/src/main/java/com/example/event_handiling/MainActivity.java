package com.example.event_handiling;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonLongClick, buttonOnTouch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLongClick = findViewById(R.id.onlclick_1);
        buttonOnTouch = findViewById(R.id.ontouch_1);

        buttonLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "I am Long CLick", Toast.LENGTH_LONG).show();
                buttonLongClick.setText("Changed");
                buttonLongClick.setTextSize(20);
//                buttonLongClick.setBackgroundColor(Color.parseColor("#564356"));
                buttonLongClick.setBackgroundResource(R.drawable.ic_launcher_foreground);
                buttonLongClick.setTextColor(Color.parseColor("#829342"));
                buttonLongClick.setTextColor(getResources().getColor(R.color.black));
                return false;
            }
        });

        //End of long click

        buttonLongClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "I am on click", Toast.LENGTH_SHORT).show();
            }
        });

        //On touch

        buttonOnTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MainActivity.this, "I am on Touch", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
    public void onclick_1(View view){
        Toast.makeText(MainActivity.this, "Without ID", Toast.LENGTH_SHORT).show();
    }
}