package com.example.mycv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HelpActivity extends AppCompatActivity {

    ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        imgId();

        //Ação do botão de "back": Abrir a activity "main".
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, MainActivity.class));

            }
        });
    }

    //Id do icon de "back"
    public void imgId(){
        imgBack = findViewById(R.id.btnBack);
    }
}