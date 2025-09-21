package com.example.aplikasiperpustakaan;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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

public class HalamanLogin extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String foto;
    public static String jurusan;
    public static String kelas;
    public static String nama;
    public static String nis;
    public static String nomorhp;
    public static String password;
    public static PreferenceHelper preferenceHelper;
    public static String status = "";
    public static String username;
    Button btnLogin;
    String channelid = "default";
    String channelnotif = "channelku";
    EditText etPassword;
    EditText etUsername;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    boolean passwordVisible;
    private Runnable runnable = new Runnable() {
        public void run() {
            HalamanLogin.this.tampilkanNotifikasi();
            HalamanLogin.this.handler.postDelayed(this, 1000);
        }
    };
    TextView tvRegister;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.halaman_login);
        preferenceHelper = new PreferenceHelper(this);
        this.tvRegister = (TextView) findViewById(R.id.tvRegister);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        String string = Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
        this.etPassword.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 1 || event.getRawX() < ((float) (HalamanLogin.this.etPassword.getRight() - HalamanLogin.this.etPassword.getCompoundDrawables()[2].getBounds().width()))) {
                    return false;
                }
                int selection = HalamanLogin.this.etPassword.getSelectionEnd();
                if (HalamanLogin.this.passwordVisible) {
                    HalamanLogin.this.etPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.showpassword, 0);
                    HalamanLogin.this.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    HalamanLogin.this.passwordVisible = false;
                } else {
                    HalamanLogin.this.etPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.hidepassword, 0);
                    HalamanLogin.this.etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    HalamanLogin.this.passwordVisible = true;
                }
                HalamanLogin.this.etPassword.setSelection(selection);
                return true;
            }
        });
        this.tvRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HalamanLogin.this.startActivity(new Intent(HalamanLogin.this.getApplicationContext(), HalamanRegistrasi.class));
                HalamanLogin.this.finish();
            }
        });
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HalamanLogin.this.etUsername.getText().toString().length() == 0) {
                    HalamanLogin.this.etUsername.setError("Tidak Boleh Kosong");
                    HalamanLogin.this.etUsername.requestFocus();
                }
                if (HalamanLogin.this.etPassword.getText().toString().length() == 0) {
                    HalamanLogin.this.etPassword.setError("Tidak Boleh Kosong");
                    HalamanLogin.this.etPassword.requestFocus();
                    return;
                }
                Volley.newRequestQueue(HalamanLogin.this.getApplicationContext()).add(new StringRequest(1, new Configurasi().baseUrl() + "api/login.php", new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString(NotificationCompat.CATEGORY_STATUS);
                            if (status.equals("berhasil_login")) {
                                AnonymousClass3.this.saveInfo(jsonObject);
                                AlertDialog.Builder builder = new AlertDialog.Builder(HalamanLogin.this);
                                builder.setTitle((CharSequence) "Sukses");
                                builder.setMessage((CharSequence) "Berhasil Login");
                                builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(HalamanLogin.this, Halaman_utama_app.class);
                                        intent.addFlags(268468224);
                                        HalamanLogin.this.startActivity(intent);
                                        HalamanLogin.this.finish();
                                    }
                                });
                                builder.create().show();
                            }
                            if (status.equals("gagal_login")) {
                                AlertDialog.Builder builder2 = new AlertDialog.Builder(HalamanLogin.this);
                                builder2.setTitle((CharSequence) "Peringatan");
                                builder2.setMessage((CharSequence) "Username / Password Salah!");
                                builder2.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        HalamanLogin.this.onRestart();
                                    }
                                });
                                builder2.create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HalamanLogin.this, "terjadi kesalahan", 0).show();
                    }
                }) {
                    /* access modifiers changed from: protected */
                    public Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> form = new HashMap<>();
                        form.put("username", HalamanLogin.this.etUsername.getText().toString());
                        form.put("password", HalamanLogin.this.etPassword.getText().toString());
                        return form;
                    }
                });
            }

            /* access modifiers changed from: private */
            public void saveInfo(JSONObject response) {
                HalamanLogin.preferenceHelper.putIsLogin(true);
                try {
                    HalamanLogin.foto = response.getString("foto");
                    HalamanLogin.nis = response.getString("nis");
                    HalamanLogin.nama = response.getString("nama");
                    HalamanLogin.kelas = response.getString("kelas");
                    HalamanLogin.jurusan = response.getString("jurusan");
                    HalamanLogin.nomorhp = response.getString("nomorhp");
                    HalamanLogin.username = response.getString("username");
                    HalamanLogin.password = response.getString("password");
                    HalamanLogin.preferenceHelper.putNama(HalamanLogin.nama);
                    HalamanLogin.preferenceHelper.putUsername(HalamanLogin.username);
                    HalamanLogin.preferenceHelper.putPassword(HalamanLogin.password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
                    HalamanLogin.nama = jsonObject.getString("nama");
                    if (status.equals("aktif")) {
                        HalamanLogin.this.notif();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HalamanLogin.this.getApplicationContext(), "Maaf, Anda Tidak Bisa Absen Lagi", 0).show();
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
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), this.channelid).setSmallIcon((int) R.drawable.logokemendikbud).setContentText(nama + ", Kembalikan Buku Anda!").setContentTitle("Notifikasi").setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2));
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

    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }
}
