package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;

public class Halamanutama extends AppCompatActivity {
    Button Keluar;
    Button Mulai;
    Button Petunjuk;
    Button Tentang;
    ImageSlider imageSlider;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_halamanutama);
        this.Mulai = (Button) findViewById(R.id.Mulai);
        this.Petunjuk = (Button) findViewById(R.id.Petunjuk);
        this.Tentang = (Button) findViewById(R.id.Tentang);
        this.Keluar = (Button) findViewById(R.id.Keluar);
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(Integer.valueOf(R.drawable.patungnaga), "Patung Naga", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(Integer.valueOf(R.drawable.tuguaspal), "Tugu Aspal", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(Integer.valueOf(R.drawable.tugubusel), "Tugu Buton selatan", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(Integer.valueOf(R.drawable.gerbangbuteng), "Gerbang Buton Tengah", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(Integer.valueOf(R.drawable.tamannasionalwakatobi), "Taman Nasional Wakatobi", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(Integer.valueOf(R.drawable.bentengkulisusu), "Benteng Kulisusu", ScaleTypes.CENTER_CROP));
        ImageSlider imageSlider2 = (ImageSlider) findViewById(R.id.image_slider);
        this.imageSlider = imageSlider2;
        imageSlider2.setImageList(imageList);
        this.Mulai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Halamanutama.this.startActivity(new Intent(Halamanutama.this.getApplicationContext(), Daftarwisata.class));
            }
        });
        this.Petunjuk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Halamanutama.this.startActivity(new Intent(Halamanutama.this.getApplicationContext(), Petunjuk.class));
            }
        });
        this.Tentang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Halamanutama.this.startActivity(new Intent(Halamanutama.this.getApplicationContext(), Tentang.class));
            }
        });
        this.Keluar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Halamanutama.this.finish();
            }
        });
    }
}
