package com.example.mycv.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mycv.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HelpActivity extends AppCompatActivity {


    private TextView txtHourHelp;
    private ImageButton imgBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        findId();
        buttonActions();
        dateFormat();


    }

    public void findId(){
        imgBtnStart = findViewById(R.id.img_btn_start_help);
        txtHourHelp = findViewById(R.id.hour_help);
    }


    private void buttonActions(){
        imgBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, MainActivity.class));
            }
        });
    }


    private void dateFormat(){
        Locale locate = new Locale("pt", "BR");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", locate);
        Handler handler = new Handler(Looper.getMainLooper());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Date hour = Calendar.getInstance().getTime();
                String hourFormated = simpleDateFormat.format(hour);
                txtHourHelp.setText(hourFormated);

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(runnable);
    }
}