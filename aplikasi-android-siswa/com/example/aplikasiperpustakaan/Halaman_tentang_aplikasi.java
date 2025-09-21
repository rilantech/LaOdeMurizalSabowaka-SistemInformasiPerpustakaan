package com.example.aplikasiperpustakaan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Halaman_tentang_aplikasi extends AppCompatActivity {
    ImageView button_logout;
    ImageView foto;
    ImageView tombol_kembali;
    TextView tvNIS;
    TextView tvNama;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_halaman_tentang_aplikasi);
        this.tombol_kembali = (ImageView) findViewById(R.id.tombol_kembali);
        this.tvNama = (TextView) findViewById(R.id.tvNama);
        this.tvNIS = (TextView) findViewById(R.id.tvNIS);
        this.foto = (ImageView) findViewById(R.id.foto);
        ImageView imageView = (ImageView) findViewById(R.id.butonlogout);
        this.button_logout = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Halaman_tentang_aplikasi.this);
                builder.setMessage("Yakin Ingin Logout ?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int position) {
                        HalamanLogin.preferenceHelper.putIsLogin(false);
                        Intent intent = new Intent(Halaman_tentang_aplikasi.this, HalamanLogin.class);
                        intent.addFlags(268468224);
                        Halaman_tentang_aplikasi.this.startActivity(intent);
                        Halaman_tentang_aplikasi.this.finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
            }
        });
        this.tvNama.setText(HalamanLogin.username.toUpperCase());
        this.tvNIS.setText(HalamanLogin.nis);
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(new Configurasi().baseUrl() + "public/img/" + HalamanLogin.foto).circleCrop()).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(this.foto);
        this.tombol_kembali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Halaman_tentang_aplikasi.this.finish();
            }
        });
    }
}
