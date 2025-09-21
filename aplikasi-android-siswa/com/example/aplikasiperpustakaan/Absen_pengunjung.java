package com.example.aplikasiperpustakaan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Absen_pengunjung extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    public static String hasil_scan;
    public static String isikepentingan;
    public static EditText kepentingan;
    public static Boolean pesan = false;
    public static Boolean status_absensi = false;
    ImageView buton_logout;
    ImageView foto;
    FrameLayout framelayout;
    private ZXingScannerView mScannerView;
    ImageView tombol_kembali;
    TextView tvNIS;
    TextView tvNama;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.absen_pengunjung);
        this.framelayout = (FrameLayout) findViewById(R.id.frame_layout_camera);
        this.tombol_kembali = (ImageView) findViewById(R.id.tombol_kembali);
        this.tvNama = (TextView) findViewById(R.id.tvNama);
        this.tvNIS = (TextView) findViewById(R.id.tvNIS);
        this.foto = (ImageView) findViewById(R.id.foto);
        kepentingan = (EditText) findViewById(R.id.kepentingan);
        this.buton_logout = (ImageView) findViewById(R.id.butonlogout);
        this.tvNama.setText(HalamanLogin.username.toUpperCase());
        this.tvNIS.setText(HalamanLogin.nis);
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(new Configurasi().baseUrl() + "public/img/" + HalamanLogin.foto).circleCrop()).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(this.foto);
        this.buton_logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Absen_pengunjung.this);
                builder.setMessage("Yakin Ingin Logout ?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int position) {
                        HalamanLogin.preferenceHelper.putIsLogin(false);
                        Intent intent = new Intent(Absen_pengunjung.this, HalamanLogin.class);
                        intent.addFlags(268468224);
                        Absen_pengunjung.this.startActivity(intent);
                        Absen_pengunjung.this.finish();
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
        this.tombol_kembali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Absen_pengunjung.this.finish();
            }
        });
        initScannerView();
    }

    private void initScannerView() {
        ZXingScannerView zXingScannerView = new ZXingScannerView(this);
        this.mScannerView = zXingScannerView;
        zXingScannerView.setAutoFocus(true);
        this.mScannerView.setResultHandler(this);
        this.mScannerView.setAspectTolerance(100.0f);
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
        pesan = true;
        this.mScannerView.stopCamera();
    }

    public void handleResult(Result rawResult) {
        Intent intent = new Intent();
        intent.putExtra("teks_hadir", rawResult.getText());
        hasil_scan = String.valueOf(rawResult);
        setResult(-1, intent);
        finish();
    }
}
