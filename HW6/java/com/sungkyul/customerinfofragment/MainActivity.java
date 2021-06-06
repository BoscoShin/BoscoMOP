package com.sungkyul.customerinfofragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentInteractionListenr{

    InputFragment inputFragment;
    private OutputFragment outputFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("20160919박원용");

        inputFragment = (InputFragment)getSupportFragmentManager().findFragmentById(R.id.inputFragment);
        outputFragment = new OutputFragment();
    }






    @Override
    public void onFragmentInteraction(String Name, String Age, String Birth) {
        outputFragment.setTextView(Name, Age, Birth);
    }
}
