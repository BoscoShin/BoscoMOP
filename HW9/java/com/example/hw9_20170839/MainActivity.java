package com.example.hw9_20170839;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.aw);
        setTitle("과제9_20170839신원섭");

        final int VoteCount[] = new int[9]; //0~9
        for(int i = 0; i<9; i++)
            VoteCount[i] = 0;

        ImageView imageView[] = new ImageView[9];
        Integer imageID[] =
                {R.id.Pic1, R.id.Pic2, R.id.Pic3,
                R.id.Pic4, R.id.Pic5, R.id.Pic6,
                R.id.Pic7, R.id.Pic8, R.id.Pic9};
        final String imageName[] =
                {"독서하는 소녀,","꽃장식 모자 소녀", " 부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두자매",
                "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};

        for(int i = 0; i < imageID.length; i++){
            final int index; // index 필수!!!
            index = i;
            imageView[index] = (ImageView) findViewById(imageID[index]);
            imageView[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VoteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imageName[index]+ "총"+ VoteCount[index]+"표",
                            Toast.LENGTH_SHORT).show();

                }
            });
        }
        Button btnFin = (Button)findViewById(R.id.btnResult);
        btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("VoteCount",VoteCount);
                intent.putExtra("imageName", imageName);

                startActivity(intent);
            }
        });
    }
}