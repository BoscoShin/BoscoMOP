package com.example.hw8_20170839;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView Mp;
    TextView txtView1;
    int curNum;
    File[] imageF;
    String imageN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("과제8_20170839신원섭");
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},MODE_PRIVATE);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.aw);

        btnPrev = (Button) findViewById(R.id.PrevB);
        btnNext = (Button) findViewById(R.id.NextB);
        Mp = (myPictureView) findViewById(R.id.PictureView1);
        txtView1 = (TextView) findViewById(R.id.numT);


        imageF = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures/Pic8_2").listFiles();
        imageN = imageF[0].toString();
        Mp.imagePath = imageN;

        int total = imageF.length; //총 11장 [0~10]
        txtView1.setText(curNum+1 + "/" + total);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum<=0){
                    //첫장에서 뒤로가기
                    curNum += imageF.length-1; //0 = 9
                    imageN = imageF[curNum].toString();
                    Mp.imagePath = imageN;
                    txtView1.setText(curNum+1 + "/" + total);
                    Mp.invalidate();
                }else{
                    curNum--; //숫자 줄어들기
                    imageN = imageF[curNum].toString();
                    Mp.imagePath=imageN;
                    txtView1.setText(curNum+1 + "/" + total);
                    Mp.invalidate();
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum>=imageF.length-1){
                    curNum -= imageF.length-1;
                    imageN = imageF[curNum].toString();
                    Mp.imagePath = imageN;
                    txtView1.setText(curNum+1 + "/" + total);
                    Mp.invalidate();
                }else{
                    curNum++;
                    imageN = imageF[curNum].toString();
                    Mp.imagePath=imageN;
                    txtView1.setText(curNum+1 + "/" + total);
                    Mp.invalidate();
                }
            }
        });


    }
}
