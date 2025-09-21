package com.example.aplikasiperpustakaan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.json.JSONException;
import org.json.JSONObject;

public class Tambahtagihan extends AppCompatActivity {
    public static String gnohp;
    public static String tanggal;
    EditText etBulan;
    EditText etJumlahbayar;
    EditText etNama;
    EditText etNomorpelanggan;
    EditText etPenggunaanair;
    Button simpan;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_tambahtagihan);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.etNomorpelanggan = (EditText) findViewById(R.id.etNomorpelanggan);
        this.etNama = (EditText) findViewById(R.id.etNama);
        this.etBulan = (EditText) findViewById(R.id.etBulan);
        this.etPenggunaanair = (EditText) findViewById(R.id.etPenggunaair);
        this.etJumlahbayar = (EditText) findViewById(R.id.etJumlahbayar);
        this.simpan = (Button) findViewById(R.id.btnsimpan);
        CharSequence format = DateFormat.format("EEEE, dd MMMM yyyy", new Date().getTime());
        tanggal = getCurretDate();
        if (getIntent().hasExtra("tambah")) {
            getData();
        }
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.simpan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Tambahtagihan.this.etNomorpelanggan.getText().toString().length() == 0) {
                    Tambahtagihan.this.etNomorpelanggan.setError("Tidak Boleh Kosong");
                }
                if (Tambahtagihan.this.etNama.getText().toString().length() == 0) {
                    Tambahtagihan.this.etNama.setError("Tidak Boleh Kosong");
                }
                if (Tambahtagihan.this.etBulan.getText().toString().length() == 0) {
                    Tambahtagihan.this.etBulan.setError("Tidak Boleh Kosong");
                }
                if (Tambahtagihan.this.etPenggunaanair.getText().toString().length() == 0) {
                    Tambahtagihan.this.etPenggunaanair.setError("Tidak Boleh Kosong");
                }
                if (Tambahtagihan.this.etJumlahbayar.getText().toString().length() == 0) {
                    Tambahtagihan.this.etJumlahbayar.setError("Tidak Boleh Kosong");
                    return;
                }
                Volley.newRequestQueue(Tambahtagihan.this).add(new StringRequest(1, new Configurasi().baseUrl() + "admin/tambahtagihan.php", new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            if (new JSONObject(response).getString(NotificationCompat.CATEGORY_STATUS).equals("berhasil_simpan")) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Tambahtagihan.this);
                                builder.setTitle((CharSequence) "Sukses");
                                builder.setMessage((CharSequence) "Berhasil Tersimpan");
                                builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Tambahtagihan.this.startActivity(new Intent(Tambahtagihan.this, datapelanggan.class));
                                        Tambahtagihan.this.finish();
                                    }
                                });
                                builder.create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Tambahtagihan.this, "Error :" + error.getMessage(), 0).show();
                    }
                }) {
                    /* access modifiers changed from: protected */
                    public Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> myParams = new HashMap<>();
                        myParams.put("nopelanggan", Tambahtagihan.this.etNomorpelanggan.getText().toString());
                        myParams.put("nama", Tambahtagihan.this.etNama.getText().toString());
                        myParams.put("nohp", Tambahtagihan.gnohp);
                        myParams.put("tgl_bayar", Tambahtagihan.tanggal);
                        myParams.put("bulan", Tambahtagihan.this.etBulan.getText().toString());
                        myParams.put("penggunaan_air", Tambahtagihan.this.etPenggunaanair.getText().toString());
                        myParams.put("jumlah_bayar", Tambahtagihan.this.etJumlahbayar.getText().toString());
                        return myParams;
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void getData() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "admin/get_data.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response).getJSONObject("data");
                    String gnama = jsonObject.getString("nama");
                    String gnopelanggan = jsonObject.getString("nopelanggan");
                    Tambahtagihan.gnohp = jsonObject.getString("nohp");
                    String string = jsonObject.getString("alamat");
                    String string2 = jsonObject.getString("fotoprofil");
                    String string3 = jsonObject.getString("username");
                    String string4 = jsonObject.getString("password");
                    Tambahtagihan.this.etNama.setText(gnama);
                    Tambahtagihan.this.etNomorpelanggan.setText(gnopelanggan);
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
                form.put(UploadTaskParameters.Companion.CodingKeys.id, Tambahtagihan.this.getIntent().getStringExtra("tambah"));
                return form;
            }
        });
    }

    public String getCurretDate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(1);
        int month = c.get(2);
        return c.get(5) + "/" + (month + 1) + "/" + year;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
