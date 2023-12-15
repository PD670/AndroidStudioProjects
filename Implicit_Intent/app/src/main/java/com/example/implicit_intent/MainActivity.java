package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button v_camera,v_contactList,v_imageGallery,v_dial,v_browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.entry_data);
        v_camera = findViewById(R.id.b_camera);
        v_contactList = findViewById(R.id.b_contact_list);
        v_imageGallery = findViewById(R.id.b_imageGallery);
        v_dial = findViewById(R.id.b_dial);
        v_browser = findViewById(R.id.b_browser);

        //Camera
        v_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent();
                ii.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(ii);
            }
        });
         //video
        v_camera.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent ii = new Intent();
                ii.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(ii);
                return false;
            }
        });

        v_contactList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_VIEW);
                ii.setData(Uri.parse("content://contacts/people/"));
                startActivity(ii);
            }
        });

        v_imageGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_VIEW);
                ii.setData(Uri.parse("content://media/external/images/media/"));
                startActivity(ii);
            }
        });

        v_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_DIAL);
                ii.setData(Uri.parse("tel:" + editText.getText()));
                startActivity(ii);
            }
        });

        v_browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent();
                ii.setAction(Intent.ACTION_VIEW);
//                ii.setData(Uri.parse("https://www.google.com/"));//For static
                ii.setData(Uri.parse("https:" + editText.getText()));//For dynamic
                startActivity(ii);
            }
        });
    }
}