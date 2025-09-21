package com.example.aplikasiperpustakaan;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationService extends Service {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String buku = "";
    public static String nama = "";
    String channelid = "default";
    String channelnotif = "channelku";
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
            if (HalamanLogin.status != null) {
                NotificationService.this.handler.postDelayed(this, 1000);
                NotificationService.this.tampilkanNotifikasi();
            }
        }
    };

    public void onCreate() {
        this.handler.postDelayed(this.runnable, 2000);
        super.onCreate();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* access modifiers changed from: private */
    public void tampilkanNotifikasi() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "api/notifikasi_pengembalian_buku.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("notifikasi");
                    NotificationService.nama = jsonObject.getString("nama");
                    NotificationService.buku = jsonObject.getString("buku");
                    if (status.equals("aktif")) {
                        NotificationService.this.notif();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NotificationService.this.getApplicationContext(), "Maaf, Anda Tidak Bisa Absen Lagi", 0).show();
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
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder((Context) this, this.channelid).setSmallIcon((int) R.drawable.logokemendikbud).setContentText("Hallo " + nama + ",\nBuku " + buku + " Yang Anda Pinjam\n Telah Habis Waktu Peminjamannya. \nDi Mohon Agar \nSegera Di Kembalikandi Perpustakaan!").setContentTitle("Notifikasi").setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2));
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
}
