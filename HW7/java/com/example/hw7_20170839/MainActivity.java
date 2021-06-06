package com.example.hw7_20170839;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView TName, Temail;
    Button ClickID;
    EditText NameDig, EmailDig;
    TextView ToText;
    View DigView, ToastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("과제7_20170839신원섭");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.aw);

        TName = (TextView) findViewById(R.id.Tname);
        Temail = (TextView) findViewById(R.id.Temail);
        ClickID = (Button) findViewById(R.id.click_id);

        ClickID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DigView = (View) View.inflate(MainActivity.this,
                        R.layout.dialog1,null);
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("사용자의 정보입력");
                dig.setIcon(R.drawable.ic_menu_allfriends);
                dig.setView(DigView);
                NameDig = (EditText)DigView.findViewById(R.id.namedig);
                EmailDig = (EditText) DigView.findViewById(R.id.maildig);

                NameDig.setText(TName.getText());
                EmailDig.setText(Temail.getText());
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TName.setText(NameDig.getText());
                        Temail.setText(EmailDig.getText());
                    }
                });
                dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                           ToastView = (View) View.inflate(MainActivity.this, R.layout.c_to, null);
                           ToText = (TextView) ToastView.findViewById(R.id.Toasttest);
                           ToText.setText("취소했습니다.");
                           toast.setView(ToastView);
                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset = (int) (Math.random() * display.getWidth());
                        int yOffset = (int) (Math.random() * display.getHeight());
                           toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                           toast.show();
                    }
                });
                dig.show();
            }
        });
    }
}