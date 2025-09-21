package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;

public class HalUtama extends AppCompatActivity {
    RatingBar ratingBar;
    Button tambah;
    Button tombol_mulai;
    Button tombollogout;
    ImageView tombolyt;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_hal_utama);
        this.tombol_mulai = (Button) findViewById(R.id.tombol_mulai);
        this.tombollogout = (Button) findViewById(R.id.tombollogout);
        ImageView imageView = (ImageView) findViewById(R.id.tombolyt);
        this.tombolyt = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse("https://www.facebook.com/"));
                HalUtama.this.startActivity(intent);
            }
        });
        this.tombol_mulai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HalUtama.this.startActivity(new Intent(HalUtama.this.getApplicationContext(), Daftarwisata.class));
            }
        });
        this.tombol_mulai.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.tombollogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse("https://www.youtube.com/@editorbangun6860"));
                HalUtama.this.startActivity(intent);
            }
        });
    }
}
