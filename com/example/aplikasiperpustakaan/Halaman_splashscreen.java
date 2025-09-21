package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Halaman_splashscreen extends AppCompatActivity {
    public static SharedPreferences getData;
    ImageView imageView3;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_halaman_splashscreen);
        getData = getSharedPreferences("data", 0);
        this.imageView3 = (ImageView) findViewById(R.id.gambarwisata3);
        getWindow().getDecorView().setSystemUiVisibility(4);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Halaman_splashscreen.this.startActivity(new Intent(Halaman_splashscreen.this.getApplicationContext(), HalamanLogin.class));
                Halaman_splashscreen.this.finish();
            }
        }, 4000);
    }
}
