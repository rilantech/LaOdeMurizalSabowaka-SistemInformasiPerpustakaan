package com.example.aplikasiperpustakaan;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailPengaduan extends AppCompatActivity {
    TextView isipengaduan;
    TextView nama;
    TextView nopelanggan;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_detail_pengaduan);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.nopelanggan = (TextView) findViewById(R.id.tvNopelanggan);
        this.nama = (TextView) findViewById(R.id.tvNama);
        this.isipengaduan = (TextView) findViewById(R.id.tvIsipengaduan);
        if (getIntent().hasExtra("detail2")) {
            getData();
        }
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /* access modifiers changed from: package-private */
    public void getData() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "admin/get_data_pengaduan.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response).getJSONObject("data");
                    String gnopelanggan = jsonObject.getString("nopelanggan");
                    String gnama = jsonObject.getString("nama");
                    String gisipengaduan = jsonObject.getString("isipengaduan");
                    DetailPengaduan.this.nopelanggan.setText(gnopelanggan);
                    DetailPengaduan.this.nama.setText(gnama);
                    DetailPengaduan.this.isipengaduan.setText(gisipengaduan);
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
                form.put(UploadTaskParameters.Companion.CodingKeys.id, DetailPengaduan.this.getIntent().getStringExtra("detail2"));
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
