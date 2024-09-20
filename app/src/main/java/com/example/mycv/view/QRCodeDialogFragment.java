package com.example.mycv.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mycv.R;
import com.example.mycv.viewmodel.QRCodeViewModel;

public class QRCodeDialogFragment extends DialogFragment {

    private QRCodeViewModel qrCodeViewModel;
    private ImageView qrCodeImageView;
    private Button closeButton, downloadButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qr_code, container, false);

        qrCodeImageView = view.findViewById(R.id.qrCodeImageView);
        closeButton = view.findViewById(R.id.btnClose);
        downloadButton = view.findViewById(R.id.btnDownload);

        qrCodeViewModel = new ViewModelProvider(this).get(QRCodeViewModel.class);

        qrCodeViewModel.getQrCodeBitmap().observe(getViewLifecycleOwner(), new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                qrCodeImageView.setImageBitmap(bitmap);
            }
        });

        // Gerar o QR Code com uma URL (substitua com o seu link)
        String url = "https://docs.google.com/document/d/1Q5GeihxRO2Y30sPlsYgzKGz0jZ-shqeG/edit?usp=sharing&ouid=101041961970455627850&rtpof=true&sd=true";
        qrCodeViewModel.generateQRCode(url);

        // Botão para fechar o Dialog
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        //Ação do botão de "doc": abrir o google drive com o meu curriculo.
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/1Q5GeihxRO2Y30sPlsYgzKGz0jZ-shqeG/edit?usp=sharing&ouid=101041961970455627850&rtpof=true&sd=true")));
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            // Definir o fundo arredondado
            getDialog().getWindow().setBackgroundDrawableResource(R.drawable.rounded_border);
            // Definir o tamanho do Dialog
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
