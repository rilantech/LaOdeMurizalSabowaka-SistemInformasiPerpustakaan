package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class Daftarwisata extends AppCompatActivity {
    public static Boolean status_cardviewbaubau = false;
    public static Boolean status_cardviewbuton = false;
    public static Boolean status_cardviewbutonselatan = false;
    public static Boolean status_cardviewbutontengah = false;
    public static Boolean status_cardviewbutonutara = false;
    public static Boolean status_cardviewwakatobi = false;
    CardView cardviewbaubau;
    CardView cardviewbuton;
    CardView cardviewbutonselatan;
    CardView cardviewbutontengah;
    CardView cardviewbutonutara;
    CardView cardviewwakatobi;
    Toolbar toolbar;
    VideoView video;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_daftarwisata);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.video = (VideoView) findViewById(R.id.video);
        this.cardviewbaubau = (CardView) findViewById(R.id.cardviewbaubau);
        this.cardviewbuton = (CardView) findViewById(R.id.cardviewbuton);
        this.cardviewbutonselatan = (CardView) findViewById(R.id.cardviewbutonselatan);
        this.cardviewbutontengah = (CardView) findViewById(R.id.cardviewbutontengah);
        this.cardviewwakatobi = (CardView) findViewById(R.id.cardviewwakatobi);
        this.cardviewbutonutara = (CardView) findViewById(R.id.cardviewbutonutara);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bentengkeraton));
        this.video.start();
        this.video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        this.cardviewbaubau.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Daftarwisata.this.startActivity(new Intent(Daftarwisata.this.getApplicationContext(), Daftarwisatapulaubuton.class));
                Daftarwisata.status_cardviewbaubau = true;
            }
        });
        this.cardviewbuton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Daftarwisata.this.startActivity(new Intent(Daftarwisata.this.getApplicationContext(), Daftarwisatapulaubuton.class));
                Daftarwisata.status_cardviewbuton = true;
            }
        });
        this.cardviewbutonselatan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Daftarwisata.this.startActivity(new Intent(Daftarwisata.this.getApplicationContext(), Daftarwisatapulaubuton.class));
                Daftarwisata.status_cardviewbutonselatan = true;
            }
        });
        this.cardviewbutontengah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Daftarwisata.this.startActivity(new Intent(Daftarwisata.this.getApplicationContext(), Daftarwisatapulaubuton.class));
                Daftarwisata.status_cardviewbutontengah = true;
            }
        });
        this.cardviewwakatobi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Daftarwisata.this.startActivity(new Intent(Daftarwisata.this.getApplicationContext(), Daftarwisatapulaubuton.class));
                Daftarwisata.status_cardviewwakatobi = true;
            }
        });
        this.cardviewbutonutara.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Daftarwisata.this.startActivity(new Intent(Daftarwisata.this.getApplicationContext(), Daftarwisatapulaubuton.class));
                Daftarwisata.status_cardviewbutonutara = true;
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.video.start();
    }
}
