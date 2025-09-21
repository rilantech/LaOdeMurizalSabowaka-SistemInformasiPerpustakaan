package com.example.aplikasiperpustakaan;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.tabs.TabLayout;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Halaman_utama_app extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String buku = "";
    public static String nama = "";
    Halaman adapter;
    ImageView buton_logout;
    String channelid = "default";
    String channelnotif = "channelku";
    ImageView foto;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
            if (HalamanLogin.status != null) {
                Halaman_utama_app.this.handler.postDelayed(this, 1000);
                Halaman_utama_app.this.tampilkanNotifikasi();
            }
        }
    };
    TabLayout tabLayout;
    TextView tvNIS;
    TextView tvNama;
    ViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.halaman_utama_app);
        this.tvNama = (TextView) findViewById(R.id.tvNama);
        this.tvNIS = (TextView) findViewById(R.id.tvNIS);
        this.foto = (ImageView) findViewById(R.id.foto);
        this.tabLayout = (TabLayout) findViewById(R.id.tab);
        this.viewPager = (ViewPager) findViewById(R.id.view_pager);
        this.buton_logout = (ImageView) findViewById(R.id.butonlogout);
        this.tvNama.setText(HalamanLogin.username.toUpperCase());
        this.tvNIS.setText(HalamanLogin.nis);
        this.buton_logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Halaman_utama_app.this);
                builder.setMessage("Yakin Ingin Logout ?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int position) {
                        HalamanLogin.preferenceHelper.putIsLogin(false);
                        Intent intent = new Intent(Halaman_utama_app.this, HalamanLogin.class);
                        intent.addFlags(268468224);
                        Halaman_utama_app.this.startActivity(intent);
                        Halaman_utama_app.this.finish();
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
        ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(new Configurasi().baseUrl() + "public/img/" + HalamanLogin.foto).circleCrop()).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(this.foto);
        Halaman halaman = new Halaman(getApplicationContext(), getSupportFragmentManager(), this.tabLayout.getTabCount());
        this.adapter = halaman;
        this.viewPager.setAdapter(halaman);
        this.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout));
        this.tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {
                Halaman_utama_app.this.viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void tampilkanNotifikasi() {
        Volley.newRequestQueue(getApplicationContext()).add(new StringRequest(1, new Configurasi().baseUrl() + "api/notifikasi_pengembalian_buku.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("notifikasi");
                    Halaman_utama_app.nama = jsonObject.getString("nama");
                    Halaman_utama_app.buku = jsonObject.getString("buku");
                    if (status.equals("aktif")) {
                        Halaman_utama_app.this.notif();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Halaman_utama_app.this.getApplicationContext(), "Maaf, Anda Tidak Bisa Absen Lagi", 0).show();
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

    /* access modifiers changed from: private */
    public void notif() {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), this.channelid).setSmallIcon((int) R.drawable.logokemendikbud).setContentText("Hallo " + nama + ",\n Buku " + buku + " Yang Anda Pinjam\n Telah Habis Waktu\n Peminjamannya. Di Mohon\n Agar Segera Di\n Kembalikandi Perpustakaan!").setContentTitle("Notifikasi").setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2));
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(this.channelnotif, "contoh channel", 4);
            notificationChannel.enableLights(true);
            notificationBuilder.setChannelId(this.channelnotif);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            } else {
                throw new AssertionError();
            }
        }
        if (notificationManager != null) {
            notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        startService(new Intent(this, NotificationService.class));
        super.onStop();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
