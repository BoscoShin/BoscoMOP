package com.example.study2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> midList = new ArrayList<String>();

        final String[] mid = { "히어로즈", "24", "로스트","로스트룸", "스몰빌", "탐정몽크","빅뱅이론" +
                "프랜즈","덱스터", "아이언맨", "헐크", "울트론","마이애미","에미냄","브이","테이큰"};
        ListView list = (ListView)findViewById(R.id.listView1);

        ArrayAdapter<String > adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,midList);
        list.setAdapter(adapter);

        final EditText edt = (EditText) findViewById(R.id.edtItem);
        Button addbtn = (Button) findViewById(R.id.btnAdd);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                midList.add(edt.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                midList.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}