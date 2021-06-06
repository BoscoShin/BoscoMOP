package com.example.study_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelectionCallback {
    ListFragment listFragment;
    viewrFragment viwerFragment;

    int[] images = {R.drawable.renoir01, R.drawable.renoir02, R.drawable.renoir03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.list);
        viwerFragment =  (viewrFragment) getSupportFragmentManager().findFragmentById(R.id.viewr);
    }
    public  void onImageSelected(int position){
        viwerFragment.setImage(images[position]);
    }
}