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

    public static final int CAMERA_PIC_REQUEST = 88;
    public static final int CAMERA_REQUEST_CODE = 11;
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
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        mSelect_Pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //user clicked
            }
        });
    }

    /*
    //calling request code of camera_request_code or Gallery_request_code
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK) {// if everything is working well
            if(requestCode == CAMERA_REQUEST_CODE){

            }
        }
    }*/
}
