package com.example.mycv.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mycv.R;
import com.example.mycv.viewmodel.Typewriter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ImageButton imgBtnHelp, imgBtnBrowser, imgBtnKotlin,
            imgBtnLanguage, imgBtnJava, imgBtnAndroid, imgBtnJS,
            imgBtnHtml, imgBtnCss, imgBtnGit, imgBtnQrCode;
    private TextView txtHour;
    private Typewriter typewriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        typewriter();
        dateFormat();
        buttonActions();

    }


    public void findId(){
        typewriter = findViewById(R.id.typewriter);
        imgBtnHelp = findViewById(R.id.img_btn_help);
        imgBtnBrowser = findViewById(R.id.img_btn_browser);
        imgBtnLanguage = findViewById(R.id.img_btn_language);
        imgBtnJava = findViewById(R.id.img_btn_java);
        imgBtnAndroid = findViewById(R.id.img_btn_android);
        imgBtnJS = findViewById(R.id.img_btn_javascript);
        imgBtnHtml = findViewById(R.id.img_btn_html);
        imgBtnCss = findViewById(R.id.img_btn_css);
        txtHour = findViewById(R.id.hour);
        imgBtnGit = findViewById(R.id.img_btn_git);
        imgBtnKotlin = findViewById(R.id.img_btn_kotlin);
        imgBtnQrCode = findViewById(R.id.img_btn_doc);
    }



    private void typewriter(){
        typewriter.setText("");
        typewriter.setCharacterDelay(100);
        typewriter.animateText(getString(R.string.text_notes));
    }



    private void dialogTechnology(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("");
        alert.setMessage(getString(R.string.alert));
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.create().show();
    }



    private void buttonActions(){

        imgBtnGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GithubReposActivity.class));
            }
        });

        imgBtnKotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTechnology();
            }
        });

        imgBtnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/gabriela-cleims")));
            }
        });

        imgBtnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
            }
        });

        imgBtnLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLanguage();
            }
        });

        imgBtnJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTechnology();
            }
        });

        imgBtnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTechnology();
            }
        });

        imgBtnJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTechnology();
            }
        });

        imgBtnHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTechnology();
            }
        });

        imgBtnCss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTechnology();

            }
        });

        imgBtnQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QRCodeDialogFragment qrCodeDialogFragment = new QRCodeDialogFragment();
                qrCodeDialogFragment.show(getSupportFragmentManager(), "qrCodeDialog");
            }
        });

    }



    private void dialogLanguage(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.language_title);
        alert.setMessage(getString(R.string.alert_language));
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.create().show();

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
                txtHour.setText(hourFormated);

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(runnable);
    }



}