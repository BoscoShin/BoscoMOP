package com.example.mp2021am_20170839;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.mp2021am_20170839.R;


public class home extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup homeview = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("20170839_신원섭");

        Gallery gallery = (Gallery) homeview.findViewById(R.id.garllery); // 갤러리1
        Gallery gallery2 = (Gallery) homeview.findViewById(R.id.garllery2); //갤러리2
        Gallery gallery3 = (Gallery) homeview.findViewById(R.id.garllery3); //갤러리3

        MyGalleryAdapter mygalleryAdapter = new MyGalleryAdapter(getContext());
        MyGalleryAdapter2 mygalleryAdapter2 = new MyGalleryAdapter2(getContext());
        MyGalleryAdapter3 mygalleryAdapter3 = new MyGalleryAdapter3(getContext());

        gallery.setAdapter(mygalleryAdapter); //갤러리1 이미지 받아오기
        gallery2.setAdapter(mygalleryAdapter2); //갤러리 이미지 받아오기
        gallery3.setAdapter(mygalleryAdapter3); //이미지 받아오기

        return homeview;

    }

    public class MyGalleryAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {
                R.drawable.mov01, R.drawable.mov02,
                R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06,
                R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10,


        };

        public MyGalleryAdapter(Context C) {
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
            imageView.setLayoutParams(new Gallery.LayoutParams(300, 500));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            imageView.setImageResource(posterID[position]);

            final int pos = position;
            return imageView;
        }
    }

    public class MyGalleryAdapter2 extends BaseAdapter {
        Context context;
        Integer[] posterID = {
                R.drawable.mov11, R.drawable.mov12,
                R.drawable.mov13, R.drawable.mov14,
                R.drawable.mov15, R.drawable.mov16,
                R.drawable.mov17, R.drawable.mov18,
                R.drawable.mov19, R.drawable.mov20,


        };

        public MyGalleryAdapter2(Context C) {
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
            imageView.setLayoutParams(new Gallery.LayoutParams(300, 500));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            imageView.setImageResource(posterID[position]);

            final int pos = position;
            return imageView;
        }
    }
    public class MyGalleryAdapter3 extends BaseAdapter {
        Context context;
        Integer[] posterID = {
                R.drawable.mov21, R.drawable.mov22,
                R.drawable.mov23, R.drawable.mov24,
                R.drawable.mov25, R.drawable.mov26,
                R.drawable.mov27, R.drawable.mov28,
                R.drawable.mov29, R.drawable.mov30,


        };

        public MyGalleryAdapter3(Context C) {
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
            imageView.setLayoutParams(new Gallery.LayoutParams(300, 500));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            imageView.setImageResource(posterID[position]);

            final int pos = position;
            return imageView;
        }
    }
}