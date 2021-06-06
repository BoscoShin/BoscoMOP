package com.example.hw5_20170839;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer choron;
    RadioButton rdate, rtime;
    DatePicker dateP;
    TimePicker timeP;
    TextView tyear, tmonth, tdate, thour, tsec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.aw);
        setTitle("과제5_20170839신원섭");

        choron = (Chronometer) findViewById(R.id.cho1);
        rdate = (RadioButton) findViewById(R.id.cal);
        rtime = (RadioButton) findViewById(R.id.time);
        dateP = (DatePicker) findViewById(R.id.datepick);
        timeP = (TimePicker) findViewById(R.id.timepick);
        tyear =  (TextView) findViewById(R.id.textYear);
        tmonth = (TextView) findViewById(R.id.textMonth);
        tdate = (TextView) findViewById(R.id.textDate);
        thour = (TextView)findViewById(R.id.textHour);
        tsec = (TextView)findViewById(R.id.textSec);

        rdate.setVisibility(View.INVISIBLE);
        rtime.setVisibility(View.INVISIBLE);
        timeP.setVisibility(View.INVISIBLE);
        dateP.setVisibility(View.INVISIBLE);

        choron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choron.setBase(SystemClock.elapsedRealtime());
                choron.start();
                choron.setTextColor(Color.RED);
                rtime.setVisibility(View.VISIBLE);
                rdate.setVisibility(View.VISIBLE);
            }
        });
        rdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateP.setVisibility(View.VISIBLE);
                timeP.setVisibility(View.INVISIBLE);
            }
        });
        rtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeP.setVisibility(View.VISIBLE);
                dateP.setVisibility(View.INVISIBLE);
            }
        });

        tyear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                choron.stop();
                choron.setTextColor(Color.BLUE);
                tyear.setText(Integer.toString(dateP.getYear()));
                tmonth.setText(Integer.toString(1+ dateP.getMonth()));
                tdate.setText(Integer.toString(dateP.getDayOfMonth()));
                thour.setText(Integer.toString(timeP.getHour()));
                tsec.setText(Integer.toString(timeP.getMinute()));
                rdate.setVisibility(View.INVISIBLE);
                rtime.setVisibility(View.INVISIBLE);
                dateP.setVisibility(View.INVISIBLE);
                timeP.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }


}
