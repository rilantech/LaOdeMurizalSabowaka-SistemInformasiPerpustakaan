package com.example.aplikasiperpustakaan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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
import com.example.aplikasiperpustakaan.AdapterDataPeminjamanBuku.AdaptorDataPeminjamanBuku;
import com.example.aplikasiperpustakaan.AdapterDataPeminjamanBuku.GetDataPeminjamanBuku;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Halaman_data_peminjaman_buku extends AppCompatActivity {
    public static String kosong = "";
    AdaptorDataPeminjamanBuku adaptor;
    ImageView button_logout;
    EditText cari;
    ImageView foto;
    ListView listView;
    ArrayList<GetDataPeminjamanBuku> model;
    ImageView tombol_kembali;
    TextView tvNIS;
    TextView tvNama;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_halaman_data_peminjaman_buku);
        this.listView = (ListView) findViewById(R.id.list);
        this.tombol_kembali = (ImageView) findViewById(R.id.tombol_kembali);
        this.cari = (EditText) findViewById(R.id.cari);
        this.tvNama = (TextView) findViewById(R.id.tvNama);
        this.tvNIS = (TextView) findViewById(R.id.tvNIS);
        this.foto = (ImageView) findViewById(R.id.foto);
        ImageView imageView = (ImageView) findViewById(R.id.butonlogout);
        this.button_logout = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Halaman_data_peminjaman_buku.this);
                builder.setMessage("Yakin Ingin Logout ?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int position) {
                        HalamanLogin.preferenceHelper.putIsLogin(false);
                        Intent intent = new Intent(Halaman_data_peminjaman_buku.this, HalamanLogin.class);
                        intent.addFlags(268468224);
                        Halaman_data_peminjaman_buku.this.startActivity(intent);
                        Halaman_data_peminjaman_buku.this.finish();
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
        this.cari.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Halaman_data_peminjaman_buku.this.cari_data(charSequence.toString());
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        this.tvNama.setText(HalamanLogin.username.toUpperCase());
        this.tvNIS.setText(HalamanLogin.nis);
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(new Configurasi().baseUrl() + "public/img/" + HalamanLogin.foto).circleCrop()).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(this.foto);
        this.adaptor = new AdaptorDataPeminjamanBuku(getApplicationContext(), this.model);
        this.tombol_kembali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Halaman_data_peminjaman_buku.this.finish();
            }
        });
        load_data2();
        cari_data(kosong);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Halaman_data_peminjaman_buku.this.getApplicationContext(), Detail_peminjaman_buku.class);
                intent.putExtra("detail2", Halaman_data_peminjaman_buku.this.model.get(i).getId().toString());
                Halaman_data_peminjaman_buku.this.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void cari_data(String data) {
        final String str = data;
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "api/cari_data_peminjam.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONObject(response).getJSONArray("data");
                    Halaman_data_peminjaman_buku.this.model = new ArrayList<>();
                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject getData = jsonArray.getJSONObject(i);
                        Halaman_data_peminjaman_buku.this.model.add(new GetDataPeminjamanBuku(getData.getInt(UploadTaskParameters.Companion.CodingKeys.id), getData.getString("nomor"), getData.getString("kode_buku"), getData.getString("judul"), getData.getString("nama_pengarang"), getData.getString("mulai_pinjam"), getData.getString("batas_pinjam")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Halaman_data_peminjaman_buku.this.adaptor = new AdaptorDataPeminjamanBuku(Halaman_data_peminjaman_buku.this.getApplicationContext(), Halaman_data_peminjaman_buku.this.model);
                Halaman_data_peminjaman_buku.this.listView.setAdapter(Halaman_data_peminjaman_buku.this.adaptor);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> form = new HashMap<>();
                form.put("nama", HalamanLogin.nama);
                form.put("kode_buku", str);
                return form;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void load_data2() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "api/tampil_data_peminjaman_buku.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONObject(response).getJSONArray("data");
                    Halaman_data_peminjaman_buku.this.model = new ArrayList<>();
                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject getData = jsonArray.getJSONObject(i);
                        Halaman_data_peminjaman_buku.this.model.add(new GetDataPeminjamanBuku(getData.getInt(UploadTaskParameters.Companion.CodingKeys.id), getData.getString("nomor"), getData.getString("kode_buku"), getData.getString("judul"), getData.getString("nama_pengarang"), getData.getString("mulai_pinjam"), getData.getString("batas_pinjam")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Halaman_data_peminjaman_buku.this.adaptor = new AdaptorDataPeminjamanBuku(Halaman_data_peminjaman_buku.this.getApplicationContext(), Halaman_data_peminjaman_buku.this.model);
                Halaman_data_peminjaman_buku.this.listView.setAdapter(Halaman_data_peminjaman_buku.this.adaptor);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> form = new HashMap<>();
                form.put("nama", HalamanLogin.nama);
                return form;
            }
        });
    }
}
