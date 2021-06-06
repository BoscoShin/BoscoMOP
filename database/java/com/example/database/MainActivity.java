package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    myDBHelper myHelper;
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSearch, btnADD, btnDelete;
    SQLiteDatabase sqldb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("DB 이용");

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNum);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumeResult);

        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnADD = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        myHelper = new myDBHelper(this);
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqldb = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqldb,1,2);
                sqldb.close();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqldb = myHelper.getWritableDatabase();
                sqldb.execSQL("insert into groupTBL values ('" + edtName.getText().toString() + "', "
                        + edtNumber.getText().toString() + ");");
                sqldb.close();
                Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                btnSearch.callOnClick();
            }
        });

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqldb = myHelper.getWritableDatabase();
                    sqldb.execSQL("Update groupTBL SET gNumber = " + edtNumber.getText().toString()
                            +" Where gName =  '"+  edtName.getText().toString() +"' " );

                sqldb.close();
                Toast.makeText(getApplicationContext(), "수정됨", Toast.LENGTH_SHORT).show();

                btnSearch.callOnClick();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqldb = myHelper.getWritableDatabase();
                sqldb.execSQL("delete From groupTBL Where gName = '" + edtName.getText().toString() +"' ");
                sqldb.close();
                Toast.makeText(getApplicationContext(),"삭제됨", Toast.LENGTH_SHORT).show();
                btnSearch.callOnClick();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqldb = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqldb.rawQuery("select * From groupTBL;", null);

                String strNames = "그룹 이름" + "\r\n" + "___________" + "\r\n";
                String strNum = "인원" + "\r\n" + "__________" + "\r\n";

                while (cursor.moveToNext()){
                    strNames += cursor.getString(0) + "\r\n";
                    strNum += cursor.getString(1) + "\r\n";
                }
                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNum);

                cursor.close();
                sqldb.close();
            }
        });
    }
    public class myDBHelper extends SQLiteOpenHelper{
        public myDBHelper (Context context){
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create Table groupTBL (gName CHAR(20) PRIMARY KEY, gNumber INTEGER)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP Table if exists groupTBL");
            onCreate(db);
        }
    }
}