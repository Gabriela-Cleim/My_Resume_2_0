package com.example.mycv;

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

import com.example.mycv.view.QRCodeDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageButton imgHelp, imgBrowser, imgDoc, imgLanguage, imgJava, imgAndroid, imgJS, imgHtml, imgCss, imgGit;
    TextView txtHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgId();
        typewriter();



        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Handler handler = new Handler(Looper.getMainLooper());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Date hour = Calendar.getInstance().getTime();
                String hourFormated = simpleDateFormat.format(hour);
                txtHour.setText(hourFormated);

                // Atualiza a cada segundo
                handler.postDelayed(this, 1000);
            }
        };

        // Inicia a primeira execução
        handler.post(runnable);







        //Ação do botão de "browser": abrir o navegador com o meu linkedin.
        imgBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/gabriela-cleims")));
            }
        });

        //Ação do botão de "help": Abre a activity "help".
        imgHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
            }
        });

        //Ação do botão de "language": Abrir o dialog.
        imgLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogL();
            }
        });

        //Ação do botão de "java": Abrir o dialog.
        imgJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });

        //Ação do botão de "android": Abrir o dialog.
        imgAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });

        //Ação do botão de "javascript": Abrir o dialog.
        imgJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });

        //Ação do botão de "HTML": Abrir o dialog.
        imgHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });

        //Ação do botão de "CSS": Abrir o dialog.
        imgCss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();

            }
        });

        ImageButton openQrCodeButton = findViewById(R.id.btnDoc);

        openQrCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir o QRCodeDialogFragment
                QRCodeDialogFragment qrCodeDialogFragment = new QRCodeDialogFragment();
                qrCodeDialogFragment.show(getSupportFragmentManager(), "qrCodeDialog");
            }
        });
    }

    //Id de todas as imagens
    public void imgId(){
        imgHelp = findViewById(R.id.btnHelp);
        imgBrowser = findViewById(R.id.btnbrowser);
        imgDoc = findViewById(R.id.btnDoc);
        imgLanguage = findViewById(R.id.language);
        imgJava = findViewById(R.id.java);
        imgAndroid = findViewById(R.id.android);
        imgJS = findViewById(R.id.javascript);
        imgHtml = findViewById(R.id.html);
        imgCss = findViewById(R.id.css);
        txtHour = findViewById(R.id.hour);

    }

    //Declaração do typewriter do notes
    private void typewriter(){
        Typewriter typewriter = findViewById(R.id.type);
        typewriter.setText("");
        typewriter.setCharacterDelay(100);
        typewriter.animateText(getString(R.string.text_notes));
    }

    //Dialog para as tecnologias
    private void dialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("");
        alert.setMessage(getString(R.string.alert));
        alert.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.create().show();
    }

    //Dialog para o icon de idiomas
    private void dialogL(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(getString(R.string.alert_language));
        alert.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.create().show();
    }
}