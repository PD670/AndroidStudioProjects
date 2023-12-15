package com.example.lv_with_custom_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 ListView lv;
 Spinner sp;
 String[] division={"Dhaka","chittagong","Rangpur","Sylhet"};
 String[] area={"1000km","2000km","3000km","4000km"};
 String[] population={"10M","5M","6M","7M"};
 Integer[] ImageId={R.drawable.dhaka,R.drawable.chittagong,R.drawable.rangpur,R.drawable.sylhet};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listview
        lv=(ListView) findViewById(R.id.list);
        CustomAdapter ListAderpter = new CustomAdapter(MainActivity.this,division,ImageId,area,population);
        lv.setAdapter(ListAderpter);

        //spinner
        sp=(Spinner) findViewById(R.id.sp);
        CustomAdapter ListAderpter1 = new CustomAdapter(MainActivity.this,division,ImageId,area,population);
        sp.setAdapter(ListAderpter1);
       //link
        //set onclick for listview
        //lv.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Toast.makeText(MainActivity.this, "position", Toast.LENGTH_SHORT).show();
            //}
        //});

    }
}