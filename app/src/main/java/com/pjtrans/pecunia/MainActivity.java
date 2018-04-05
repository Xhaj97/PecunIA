package com.pjtrans.pecunia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

    public static final int REQUEST_IMAGE_CAPTURE = 11;
    Button mTake_Pic;
    Button mSelect_Pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTake_Pic = (Button) findViewById(R.id.activity_main_take_picture);
        mSelect_Pic = (Button) findViewById(R.id.activity_main_select_picture);

        mTake_Pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        mSelect_Pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //user clicked
            }
        });
    }
}
