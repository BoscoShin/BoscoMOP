package com.example.mp2021am_20170839;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Fragment fragment_Home, fragment_won, Flist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("20170839_신원섭");
        fragment_Home = new home();
        fragment_won = new Won();
        Flist = new list();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_Home).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navi);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, Flist).commit();
                        return true;
                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_Home).commit();
                        return true;
                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_won).commit();
                        return true;
                }
                return false;
            }
        });
    }
    public void setAcctionbarTitle(String Title){
        ActionBar actionBar = getSupportActionBar();
        if(actionBar == null){
            actionBar.setTitle(Title);
        }
    }
}