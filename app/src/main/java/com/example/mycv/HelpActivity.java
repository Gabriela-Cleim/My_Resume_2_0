package com.example.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelpActivity extends AppCompatActivity {


    private TextView txtHourHelp;
    private ImageButton imageButtonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        imgId();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Handler handler = new Handler(Looper.getMainLooper());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Date hour = Calendar.getInstance().getTime();
                String hourFormated = simpleDateFormat.format(hour);
                txtHourHelp.setText(hourFormated);

                // Atualiza a cada segundo
                handler.postDelayed(this, 1000);
            }
        };

        // Inicia a primeira execução
        handler.post(runnable);

        //Ação do botão de "back": Abrir a activity "main".
        imageButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, MainActivity.class));

            }
        });


    }

    //Id do icon de "back"
    public void imgId(){
        imageButtonStart = findViewById(R.id.img_btn_start_help);
        txtHourHelp = findViewById(R.id.hour_help);
    }
}