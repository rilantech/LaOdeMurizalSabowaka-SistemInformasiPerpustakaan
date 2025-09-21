package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanQrcodeAbsenPulang extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    public static String hasil_scan;
    FrameLayout framelayout;
    private ZXingScannerView mScannerView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.scan_qrcodeabsenpulang);
        this.framelayout = (FrameLayout) findViewById(R.id.frame_layout_camera);
        initScannerView();
    }

    private void initScannerView() {
        ZXingScannerView zXingScannerView = new ZXingScannerView(this);
        this.mScannerView = zXingScannerView;
        zXingScannerView.setAutoFocus(true);
        this.mScannerView.setResultHandler(this);
        this.mScannerView.setAspectTolerance(0.5f);
        this.framelayout.addView(this.mScannerView);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mScannerView.setResultHandler(this);
        this.mScannerView.startCamera();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mScannerView.stopCamera();
    }

    public void handleResult(Result rawResult) {
        Intent intent = new Intent();
        intent.putExtra("tekshadir", rawResult.getText());
        hasil_scan = String.valueOf(rawResult);
        setResult(-1, intent);
        finish();
    }
}
