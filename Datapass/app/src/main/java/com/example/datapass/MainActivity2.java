package com.example.datapass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.text_1);
        String value1 = getIntent().getExtras().getString("Key");
        tv.setText(value1);
        int value2=getIntent().getIntExtra("Result",0);
        tv.append("\nTotal price:" +value2);
}
}