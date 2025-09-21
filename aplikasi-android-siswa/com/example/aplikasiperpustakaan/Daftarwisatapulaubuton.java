package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class Daftarwisatapulaubuton extends AppCompatActivity {
    public static Boolean tombol_wisata1 = false;
    public static Boolean tombol_wisata2 = false;
    public static Boolean tombol_wisata3 = false;
    public static Boolean tombol_wisata4 = false;
    public static Boolean tombol_wisata5 = false;
    public static Boolean tombol_wisata6 = false;
    ImageView gambarwisata1;
    ImageView gambarwisata2;
    ImageView gambarwisata3;
    ImageView gambarwisata4;
    TextView judul_halaman;
    Toolbar toolbar2;
    TextView tv_wisata1;
    TextView tv_wisata2;
    TextView tv_wisata3;
    TextView tv_wisata4;
    CardView wisata1;
    CardView wisata2;
    CardView wisata3;
    CardView wisata4;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_daftarwisatapulaubuton);
        this.toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        this.wisata1 = (CardView) findViewById(R.id.wisata1);
        this.wisata2 = (CardView) findViewById(R.id.wisata2);
        this.wisata3 = (CardView) findViewById(R.id.wisata3);
        this.wisata4 = (CardView) findViewById(R.id.wisata4);
        this.judul_halaman = (TextView) findViewById(R.id.judul_halaman);
        this.gambarwisata1 = (ImageView) findViewById(R.id.gambarwisata1);
        this.gambarwisata2 = (ImageView) findViewById(R.id.gambarwisata2);
        this.gambarwisata3 = (ImageView) findViewById(R.id.gambarwisata3);
        this.gambarwisata4 = (ImageView) findViewById(R.id.gambarwisata4);
        this.tv_wisata1 = (TextView) findViewById(R.id.tv_wisata1);
        this.tv_wisata2 = (TextView) findViewById(R.id.tv_wisata2);
        this.tv_wisata3 = (TextView) findViewById(R.id.tv_wisata3);
        this.tv_wisata4 = (TextView) findViewById(R.id.tv_wisata4);
        setSupportActionBar(this.toolbar2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.wisata1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Daftarwisatapulaubuton.tombol_wisata1 = true;
                Daftarwisatapulaubuton.this.startActivity(new Intent(Daftarwisatapulaubuton.this.getApplicationContext(), Informasiwisata.class));
            }
        });
        this.wisata2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Daftarwisatapulaubuton.tombol_wisata2 = true;
                Daftarwisatapulaubuton.this.startActivity(new Intent(Daftarwisatapulaubuton.this.getApplicationContext(), Informasiwisata.class));
            }
        });
        this.wisata3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Daftarwisatapulaubuton.tombol_wisata3 = true;
                Daftarwisatapulaubuton.this.startActivity(new Intent(Daftarwisatapulaubuton.this.getApplicationContext(), Informasiwisata.class));
            }
        });
        this.wisata4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Daftarwisatapulaubuton.tombol_wisata4 = true;
                Daftarwisatapulaubuton.this.startActivity(new Intent(Daftarwisatapulaubuton.this.getApplicationContext(), Informasiwisata.class));
            }
        });
        if (Daftarwisata.status_cardviewbaubau.booleanValue()) {
            this.judul_halaman.setText("Wisata Baubau");
            this.tv_wisata1.setText("Pantai Nirwana");
            this.tv_wisata2.setText("Benteng Keraton");
            this.tv_wisata3.setText("Goa Lakasa");
            this.tv_wisata4.setText("Batu Sori");
            this.gambarwisata1.setImageResource(R.drawable.pantainirwana);
            this.gambarwisata2.setImageResource(R.drawable.bentengkeraton);
            this.gambarwisata3.setImageResource(R.drawable.goalakasa);
            this.gambarwisata4.setImageResource(R.drawable.batusori);
        }
        if (Daftarwisata.status_cardviewbuton.booleanValue()) {
            this.judul_halaman.setText("Wisata Buton");
            this.tv_wisata1.setText("Kali Biru");
            this.tv_wisata2.setText("Air Terjun Kandawu ndawuna");
            this.tv_wisata3.setText("Pantai Koguna");
            this.tv_wisata4.setText("Benteng Wasuemba");
            this.gambarwisata1.setImageResource(R.drawable.kalibiru);
            this.gambarwisata2.setImageResource(R.drawable.airterjunkandawundawuna);
            this.gambarwisata3.setImageResource(R.drawable.pantaikoguna);
            this.gambarwisata4.setImageResource(R.drawable.bentengwasuemba);
        }
        if (Daftarwisata.status_cardviewbutonselatan.booleanValue()) {
            this.judul_halaman.setText("Wisata Buton Selatan");
            this.tv_wisata1.setText("Permandian Kabura-burana");
            this.tv_wisata2.setText("Masjid Tua Wawoangi");
            this.tv_wisata3.setText("Bukit Rongi");
            this.tv_wisata4.setText("Pantai Jodoh");
            this.gambarwisata1.setImageResource(R.drawable.kaburaburana);
            this.gambarwisata2.setImageResource(R.drawable.masjidtuawawoangi);
            this.gambarwisata3.setImageResource(R.drawable.bukitrongi);
            this.gambarwisata4.setImageResource(R.drawable.pantaijodoh);
        }
        if (Daftarwisata.status_cardviewbutontengah.booleanValue()) {
            this.judul_halaman.setText("Wisata Buton Tengah");
            this.tv_wisata1.setText(" Goa Maobu");
            this.tv_wisata2.setText("Goa Koo");
            this.tv_wisata3.setText("Benteng Bombonawulu");
            this.tv_wisata4.setText("Pantai Katembe");
            this.gambarwisata1.setImageResource(R.drawable.goamaobu);
            this.gambarwisata2.setImageResource(R.drawable.goakoo);
            this.gambarwisata3.setImageResource(R.drawable.bentengbombonawulu);
            this.gambarwisata4.setImageResource(R.drawable.pantaikatembe);
        }
        if (Daftarwisata.status_cardviewwakatobi.booleanValue()) {
            this.judul_halaman.setText("Wisata Wakatobi");
            this.tv_wisata1.setText(" Taman Nasional Wakatobi");
            this.tv_wisata2.setText("Masjid Mubarok Wakatobi");
            this.tv_wisata3.setText("Benteng Liya Togo");
            this.tv_wisata4.setText("Pantai Cemara");
            this.gambarwisata1.setImageResource(R.drawable.tamannasionalwakatobi);
            this.gambarwisata2.setImageResource(R.drawable.masjidmubarok);
            this.gambarwisata3.setImageResource(R.drawable.bentengliyatogo);
            this.gambarwisata4.setImageResource(R.drawable.pantaicemara);
        }
        if (Daftarwisata.status_cardviewbutonutara.booleanValue()) {
            this.judul_halaman.setText("Wisata Buton Utara");
            this.tv_wisata1.setText(" Pantai Mumbuku");
            this.tv_wisata2.setText("Pantai Bone");
            this.tv_wisata3.setText("Air Terjun La Ocu");
            this.tv_wisata4.setText("Benteng Kulisusu");
            this.gambarwisata1.setImageResource(R.drawable.pantaimumbuku);
            this.gambarwisata2.setImageResource(R.drawable.pantaibone);
            this.gambarwisata3.setImageResource(R.drawable.airterjunlaocu);
            this.gambarwisata4.setImageResource(R.drawable.bentengkulisusu);
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public void onBackPressed() {
        super.onBackPressed();
        Daftarwisata.status_cardviewbaubau = false;
        Daftarwisata.status_cardviewbuton = false;
        Daftarwisata.status_cardviewbutonselatan = false;
        Daftarwisata.status_cardviewbutontengah = false;
        Daftarwisata.status_cardviewwakatobi = false;
        Daftarwisata.status_cardviewbutonutara = false;
    }
}
