package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class HalamanSplash1 extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_halaman_splash1);
        getWindow().getDecorView().setSystemUiVisibility(4);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                HalamanSplash1.this.startActivity(new Intent(HalamanSplash1.this.getApplicationContext(), HalUtama.class));
                HalamanSplash1.this.finish();
            }
        }, 4000);
    }
}
