package com.example.aplikasiperpustakaan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import java.util.HashMap;
import java.util.Map;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.json.JSONException;
import org.json.JSONObject;

public class Simpan_data extends AppCompatActivity {
    TextInputEditText alamat;
    TextInputEditText email;
    TextInputEditText gambar;
    TextView label;
    TextInputEditText nama;
    TextInputEditText nip;
    Button simpan_data;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_simpan_data);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.gambar = (TextInputEditText) findViewById(R.id.gambar);
        this.nama = (TextInputEditText) findViewById(R.id.nama);
        this.email = (TextInputEditText) findViewById(R.id.email);
        this.nip = (TextInputEditText) findViewById(R.id.nip);
        this.alamat = (TextInputEditText) findViewById(R.id.alamat);
        this.label = (TextView) findViewById(R.id.label);
        this.simpan_data = (Button) findViewById(R.id.simpan_data);
        if (getIntent().hasExtra("edit_data")) {
            this.label.setText("Edit Data");
            getData();
            this.simpan_data.setText("Update Data");
        }
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.simpan_data.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Simpan_data.this.gambar.getText().toString().length() == 0) {
                    Simpan_data.this.gambar.setError("Tidak Boleh Kosong");
                }
                if (Simpan_data.this.nama.getText().toString().length() == 0) {
                    Simpan_data.this.nama.setError("Tidak Boleh Kosong");
                }
                if (Simpan_data.this.email.getText().toString().length() == 0) {
                    Simpan_data.this.email.setError("Tidak Boleh Kosong");
                }
                if (Simpan_data.this.nip.getText().toString().length() == 0) {
                    Simpan_data.this.nip.setError("Tidak Boleh Kosong");
                }
                if (Simpan_data.this.alamat.getText().toString().length() == 0) {
                    Simpan_data.this.alamat.setError("Tidak Boleh Kosong");
                    return;
                }
                Volley.newRequestQueue(Simpan_data.this.getApplicationContext()).add(new StringRequest(1, new Configurasi().baseUrl() + "api/simpan.php", new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            if (new JSONObject(response).getString(NotificationCompat.CATEGORY_STATUS).equals("data_tersimpan")) {
                                Boolean _cekIntent = Boolean.valueOf(Simpan_data.this.getIntent().hasExtra("edit_data"));
                                AlertDialog.Builder builder = new AlertDialog.Builder(Simpan_data.this);
                                builder.setTitle("Sukses");
                                builder.setMessage(_cekIntent.booleanValue() ? "Data Berhasil di update" : "Data sukses tersimpan");
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Simpan_data.this.finish();
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
                        Toast.makeText(Simpan_data.this, "terjadi kesalahan", 0).show();
                    }
                }) {
                    /* access modifiers changed from: protected */
                    public Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> form = new HashMap<>();
                        form.put("gambar", Simpan_data.this.gambar.getText().toString());
                        form.put("nama", Simpan_data.this.nama.getText().toString());
                        form.put("email", Simpan_data.this.email.getText().toString());
                        form.put("nip", Simpan_data.this.nip.getText().toString());
                        form.put("alamat", Simpan_data.this.alamat.getText().toString());
                        if (Simpan_data.this.getIntent().hasExtra("edit_data")) {
                            form.put(UploadTaskParameters.Companion.CodingKeys.id, Simpan_data.this.getIntent().getStringExtra("edit_data"));
                        }
                        return form;
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void getData() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "api/get_data.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response).getJSONObject("data");
                    String ggambar = jsonObject.getString("gambar");
                    String gnama = jsonObject.getString("nama");
                    String gemail = jsonObject.getString("email");
                    String gnip = jsonObject.getString("nip");
                    String galamat = jsonObject.getString("alamat");
                    Simpan_data.this.gambar.setText(ggambar);
                    Simpan_data.this.nama.setText(gnama);
                    Simpan_data.this.email.setText(gemail);
                    Simpan_data.this.nip.setText(gnip);
                    Simpan_data.this.alamat.setText(galamat);
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
                form.put(UploadTaskParameters.Companion.CodingKeys.id, Simpan_data.this.getIntent().getStringExtra("edit_data"));
                return form;
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
