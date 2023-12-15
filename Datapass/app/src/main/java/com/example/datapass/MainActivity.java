package com.example.datapass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   Button button;
   EditText et,et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.Button_9);
        et=findViewById(R.id.et_1);
        et1=findViewById(R.id.et_2);
        et2=findViewById(R.id.et_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this, MainActivity2.class);
                String massage1=et.getText().toString().trim();
                in.putExtra("key",massage1);
                String massage2=et1.getText().toString().trim();
                int result=Integer.parseInt(massage2);
                String massage3=et2.getText().toString().trim();
                int result2=Integer.parseInt(massage3);
                int multi=result*result2;
                in.putExtra("Result",multi);
                startActivity(in);
                        startActivity(in);

            }
        });

    }
}