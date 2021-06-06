package com.example.moviegrid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰를 이용한 영화 포스터");


        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);


    }

    public class MyGridAdapter extends BaseAdapter {
        String iname[] = {
                "느루아르", "느루아르", "느루아르", "느루아르", "느루아르", "느루아르"
        };
        Integer[] posterID = {
                R.drawable.renoir01, R.drawable.renoir02, R.drawable.renoir03,
                R.drawable.renoir04,R.drawable.renoir05, R.drawable.renoir06,
                R.drawable.renoir07,
                R.drawable.renoir08, R.drawable.renoir09};

        public int getCount() {
            return posterID.length;
        }

        Context context;

        public MyGridAdapter(Context c) {
            context = c;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView iposter = (ImageView) dialogView.findViewById(R.id.Posterimg);
                    iposter.setImageResource(posterID[pos]);
                    dlg.setTitle(iname[pos]);
                    dlg.setIcon(R.drawable.ic_launcher_background);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return imageView;
        }

    }
}