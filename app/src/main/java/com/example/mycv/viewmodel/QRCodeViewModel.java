package com.example.mycv.viewmodel;

import android.graphics.Bitmap;
import android.graphics.Color;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeViewModel extends ViewModel {

    private MutableLiveData<Bitmap> qrCodeBitmap = new MutableLiveData<>();

    public LiveData<Bitmap> getQrCodeBitmap() {
        return qrCodeBitmap;
    }

    public void generateQRCode(String url) {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, 512, 512);
            Bitmap bitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.RGB_565);
            for (int x = 0; x < 512; x++) {
                for (int y = 0; y < 512; y++) {
                    bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            qrCodeBitmap.setValue(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}

