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
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.HashMap;
import java.util.Map;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.json.JSONException;
import org.json.JSONObject;

public class Detail_peminjaman_buku extends AppCompatActivity {
    TextView batas_pinjam;
    ImageView button_logout;
    ImageView foto;
    TextView judul;
    TextView kode_buku;
    TextView letak_buku;
    TextView mulai_pinjam;
    TextView nama_pengarang;
    ImageView sampul;
    ImageView tombol_kembali;
    TextView tvNIS;
    TextView tvNama;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_detail_peminjaman_buku);
        this.kode_buku = (TextView) findViewById(R.id.kode_buku);
        this.judul = (TextView) findViewById(R.id.judul);
        this.nama_pengarang = (TextView) findViewById(R.id.nama_pengarang);
        this.letak_buku = (TextView) findViewById(R.id.letak_buku);
        this.mulai_pinjam = (TextView) findViewById(R.id.mulai_pinjam);
        this.batas_pinjam = (TextView) findViewById(R.id.batas_pinjam);
        this.sampul = (ImageView) findViewById(R.id.sampul);
        this.tombol_kembali = (ImageView) findViewById(R.id.tombol_kembali);
        this.tvNama = (TextView) findViewById(R.id.tvNama);
        this.tvNIS = (TextView) findViewById(R.id.tvNIS);
        this.foto = (ImageView) findViewById(R.id.foto);
        ImageView imageView = (ImageView) findViewById(R.id.butonlogout);
        this.button_logout = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Detail_peminjaman_buku.this);
                builder.setMessage("Yakin Ingin Logout ?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int position) {
                        HalamanLogin.preferenceHelper.putIsLogin(false);
                        Intent intent = new Intent(Detail_peminjaman_buku.this, HalamanLogin.class);
                        intent.addFlags(268468224);
                        Detail_peminjaman_buku.this.startActivity(intent);
                        Detail_peminjaman_buku.this.finish();
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
                Detail_peminjaman_buku.this.finish();
            }
        });
        if (getIntent().hasExtra("detail2")) {
            getData();
        }
    }

    /* access modifiers changed from: package-private */
    public void getData() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "api/detail_peminjaman_buku.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response).getJSONObject("data");
                    String gsampul = jsonObject.getString("sampul");
                    String gkode_buku = jsonObject.getString("kode_buku");
                    String gjudul = jsonObject.getString("judul_buku");
                    String gnama_pengarang = jsonObject.getString("pengarang");
                    String gletak_buku = jsonObject.getString("letak_pada_rak");
                    String gmulai_pinjam = jsonObject.getString("mulai_pinjam");
                    String gbatas_pinjam = jsonObject.getString("batas_pinjam");
                    ((RequestBuilder) ((RequestBuilder) Glide.with(Detail_peminjaman_buku.this.getApplicationContext()).load(new Configurasi().baseUrl() + "public/img/" + gsampul).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(Detail_peminjaman_buku.this.sampul);
                    Detail_peminjaman_buku.this.kode_buku.setText(gkode_buku);
                    Detail_peminjaman_buku.this.judul.setText(gjudul);
                    Detail_peminjaman_buku.this.nama_pengarang.setText(gnama_pengarang);
                    Detail_peminjaman_buku.this.letak_buku.setText(gletak_buku);
                    Detail_peminjaman_buku.this.mulai_pinjam.setText(gmulai_pinjam);
                    Detail_peminjaman_buku.this.batas_pinjam.setText(gbatas_pinjam);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> form = new HashMap<>();
                form.put(UploadTaskParameters.Companion.CodingKeys.id, Detail_peminjaman_buku.this.getIntent().getStringExtra("detail2"));
                return form;
            }
        });
    }
}
