package com.pjtrans.pecunia;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;


public class MainActivity extends Activity {

    public static final int REQUEST_IMAGE_CAPTURE = 11;
    public static final int MULTIPLE_PERMISSIONS = 22;
    public static final int PICK_IMAGE = 1;

    String[] permissions= new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    Button mTake_Pic;
    Button mSelect_Pic;
    FloatingActionButton mInfo1; // a propos
    FloatingActionButton mInfo2; // tutoriel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(checkPermissions());

        mTake_Pic = findViewById(R.id.activity_main_take_picture);
        mSelect_Pic = findViewById(R.id.activity_main_select_picture);
        mInfo1 = findViewById(R.id.floatingActionButton1);
        mInfo2 = findViewById(R.id.floatingActionButton2);

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
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

                startActivityForResult(chooserIntent, PICK_IMAGE);
            }
        });

        mInfo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TapInfoIntent = new Intent(MainActivity.this, A_propos.class);
                startActivity(TapInfoIntent);
            }
        });

        mInfo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TapInfoIntent = new Intent(MainActivity.this, Tutoriel.class);
                startActivity(TapInfoIntent);
            }
        });
    }

    private  boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p:permissions) {
            result = ContextCompat.checkSelfPermission(this,p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),MULTIPLE_PERMISSIONS );
            return false;
        }
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQUEST_IMAGE_CAPTURE){
            Intent TapInfoIntent = new Intent(MainActivity.this, ResultActivity.class);
            startActivity(TapInfoIntent);
        }
        else if(requestCode == PICK_IMAGE) {
            //TODO: The picture analysis here
            Intent TapInfoIntent = new Intent(MainActivity.this, ResultActivity.class);
            startActivity(TapInfoIntent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permissions granted.
                } else {

                }
                // permissions list of don't granted permission
            }
        }
    }
}
