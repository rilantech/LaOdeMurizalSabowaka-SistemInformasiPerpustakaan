package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Beranda extends Fragment {
    public static CharSequence jam;
    CardView absen_pengunjung;
    TextView copyright;
    CardView data_buku;
    CardView data_peminjaman_buku;
    CardView data_pengembalian_buku;
    String status_absen;
    CardView tentang_aplikasi;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.halaman_beranda, (ViewGroup) null);
        this.absen_pengunjung = (CardView) view.findViewById(R.id.absen_pengunjung);
        this.data_peminjaman_buku = (CardView) view.findViewById(R.id.data_peminjaman_buku);
        this.data_pengembalian_buku = (CardView) view.findViewById(R.id.data_pengembalian_buku);
        this.data_buku = (CardView) view.findViewById(R.id.data_buku);
        this.tentang_aplikasi = (CardView) view.findViewById(R.id.tentang_aplikasi);
        this.copyright = (TextView) view.findViewById(R.id.copyright);
        this.data_peminjaman_buku.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Beranda.this.startActivity(new Intent(Beranda.this.getContext(), Halaman_data_peminjaman_buku.class));
            }
        });
        this.data_pengembalian_buku.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Beranda.this.startActivity(new Intent(Beranda.this.getContext(), Halaman_data_pengembalian_buku.class));
            }
        });
        this.absen_pengunjung.setOnClickListener(new Beranda$$ExternalSyntheticLambda0(this));
        this.data_buku.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Beranda.this.startActivity(new Intent(Beranda.this.getContext(), Halaman_data_buku.class));
            }
        });
        this.tentang_aplikasi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Beranda.this.startActivity(new Intent(Beranda.this.getContext(), Halaman_tentang_aplikasi.class));
            }
        });
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$0$com-example-aplikasiperpustakaan-Beranda  reason: not valid java name */
    public /* synthetic */ void m0lambda$onCreateView$0$comexampleaplikasiperpustakaanBeranda(View v) {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") == 0) {
            starScan();
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), "android.permission.CAMERA")) {
            starScan();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.CAMERA"}, 0);
        }
    }

    private void starScan() {
        startActivityForResult(new Intent(getContext(), Absen_pengunjung.class), 20);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        jam = DateFormat.format("HH:mm:ss", new Date().getTime());
        if (requestCode == 20 && resultCode == -1 && data != null) {
            String stringExtra = data.getStringExtra("teks_hadir");
            Volley.newRequestQueue(getContext()).add(new StringRequest(1, new Configurasi().baseUrl() + "api/absen.php", new Response.Listener<String>() {
                public void onResponse(String response) {
                    try {
                        if (new JSONObject(response).getString("statuspresensi").equals("berhasil_absen")) {
                            Beranda.this.getActivity();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Beranda.this.getContext(), "Maaf, Anda Tidak Bisa Absen Lagi", 0).show();
                }
            }) {
                /* access modifiers changed from: protected */
                public Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> form = new HashMap<>();
                    form.put("pengunjung", HalamanLogin.nama);
                    form.put("kelas", HalamanLogin.kelas);
                    form.put("jurusan", HalamanLogin.jurusan);
                    form.put("waktu_berkunjung", Beranda.jam.toString());
                    form.put("kepentingan", Absen_pengunjung.kepentingan.getText().toString());
                    return form;
                }
            });
            if (Absen_pengunjung.pesan.booleanValue()) {
                new SweetAlertDialog(getContext(), 2).setTitleText("Sukses").setContentText("Berhasil Absen!").show();
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 0) {
            return;
        }
        if (grantResults[0] == 0) {
            starScan();
        } else {
            Toast.makeText(getContext(), "Gagal membuka kamera", 1).show();
        }
    }
}
