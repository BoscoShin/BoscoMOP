package com.example.moviegg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        MyGalleryAdapter galleryAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galleryAdapter);
    }
    public class MyGalleryAdapter extends BaseAdapter{
        Context context;
        Integer[] posterID = {
                R.drawable.renoir01, R.drawable.renoir02,
                R.drawable.renoir03, R.drawable.renoir04,
                R.drawable.renoir05, R.drawable.renoir06,
                R.drawable.renoir01, R.drawable.renoir02,
                R.drawable.renoir03, R.drawable.renoir04,
                R.drawable.renoir05, R.drawable.renoir06,
                R.drawable.renoir01, R.drawable.renoir02,
                R.drawable.renoir03, R.drawable.renoir04,
                R.drawable.renoir05, R.drawable.renoir06
        };
        public MyGalleryAdapter(Context C){
            context = C;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(100, 150));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView iposter = (ImageView) findViewById(R.id.poster);
                    iposter.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    iposter.setImageResource(posterID[pos]);
                    return false;   
                }
            });

            return imageView;
        }
    }
}