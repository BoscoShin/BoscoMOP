package com.example.hw9_20170839;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표결과");
        //인텐트를 이용해 투표값 받아오기
        Intent intent = getIntent();
        int[] VoteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("imageName");

        Integer imageFiled[] =
                {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,
                        R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,
                        R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};

        //투표수가 많은 그림 제목 및 이미지 출력
        TextView Wintv = (TextView) findViewById(R.id.wintv);
        ImageView Winimage = (ImageView) findViewById(R.id.winimage);

        int index = 0;
        for (int i =0; i < VoteResult.length; i++){
            if (VoteResult[index] < VoteResult[i]) index = i;
        }
        Wintv.setText(imageName[index]);
        Winimage.setImageResource(imageFiled[index]);

        //9개 텍스트뷰, 레이팅바 배열
        TextView tv[] = new TextView[imageName.length];
        RatingBar rb[] = new RatingBar[imageName.length];
        //9개 텍스트뷰, 레이팅바 ID 배열
        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3,
                R.id.tv4, R.id.tv5, R.id.tv6,
                R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3,
                R.id.rbar4, R.id.rbar5, R.id.rbar6,
                R.id.rbar7, R.id.rbar8, R.id.rbar9};

        for (int i= 0; i < VoteResult.length; i++){
            tv[i] = (TextView) findViewById(tvID[i]);
            rb[i] = (RatingBar) findViewById(rbarID[i]);
        }
        for(int i =0; i<VoteResult.length; i++){
            tv[i].setText(imageName[i]);
            rb[i].setRating((float) VoteResult[i]);
        }


        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
