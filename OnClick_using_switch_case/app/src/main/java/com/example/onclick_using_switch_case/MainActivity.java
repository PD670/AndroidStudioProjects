package com.example.onclick_using_switch_case;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b_var_1;
    private Button b_var_2;
    private Button b_var_3;
    private Button b_var_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_var_1 = findViewById(R.id.b_one);
        b_var_2 = findViewById(R.id.b_two);
        b_var_3 = findViewById(R.id.b_three);
        b_var_4 = findViewById(R.id.b_four);

        b_var_1.setOnClickListener(this);
        b_var_2.setOnClickListener(this);
        b_var_3.setOnClickListener(this);
        b_var_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.b_one) {
            bclick_one();
        } else if (v.getId() == R.id.b_two) {
            bclick_two();
        } else if (v.getId() == R.id.b_three) {
            bclick_three();
        } else if (v.getId() == R.id.b_four) {
            bclick_four();
        }
    }

    private void bclick_one() {
        b_var_1.setText("stamasoft!");
        Toast.makeText(getApplicationContext(),"one show stamasoft",Toast.LENGTH_LONG).show();
    }

    private void bclick_two() {
        b_var_2.setText("Pranta Das!");
    }

    private void bclick_three() {
        b_var_3.setText("ID:");
    }

    private void bclick_four() {
        b_var_4.setText("Batch");
    }
}
