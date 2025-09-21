package com.example.aplikasiperpustakaan;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class Menu1 extends AppCompatActivity {
    public static Boolean wis1 = false;
    public static Boolean wis2 = false;
    public static Boolean wis3 = false;
    Toolbar toolbar;
    TextView tvToolbar;
    TextView tvWisata1;
    TextView tvWisata2;
    TextView tvWisata3;
    CardView wisa1;
    CardView wisa2;
    CardView wisa3;
    ImageView wisata1;
    ImageView wisata2;
    ImageView wisata3;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_menu1);
    }
}
