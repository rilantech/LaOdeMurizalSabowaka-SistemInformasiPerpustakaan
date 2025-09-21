package com.example.aplikasiperpustakaan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.denzcoskun.imageslider.ImageSlider;

public class Menu2 extends AppCompatActivity {
    public static String latitude = "";
    public static String longitude = "";
    TextView deskripsiwisata;
    ImageSlider imageSlider;
    TextView namawisata;
    Button tombollokasi;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_menu2);
    }
}
