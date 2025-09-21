package com.example.aplikasiperpustakaan;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

public class DetailPelanggan extends AppCompatActivity {
    TextView alamat;
    ImageView gambar;
    TextView nama;
    TextView nohp;
    TextView nopelanggan;
    TextView password;
    Toolbar toolbar;
    TextView username;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_detail_pelanggan);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.nama = (TextView) findViewById(R.id.tvNama);
        this.nopelanggan = (TextView) findViewById(R.id.tvNopelanggan);
        this.nohp = (TextView) findViewById(R.id.tvNohp);
        this.alamat = (TextView) findViewById(R.id.tvAlamat);
        this.gambar = (ImageView) findViewById(R.id.gambar1);
        this.username = (TextView) findViewById(R.id.tvUsername);
        this.password = (TextView) findViewById(R.id.tvPassword);
        if (getIntent().hasExtra("detail")) {
            getData();
        }
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /* access modifiers changed from: package-private */
    public void getData() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "admin/get_data.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response).getJSONObject("data");
                    String gnama = jsonObject.getString("nama");
                    String gnopelanggan = jsonObject.getString("nopelanggan");
                    String gnohp = jsonObject.getString("nohp");
                    String galamat = jsonObject.getString("alamat");
                    String gfotoprofil = jsonObject.getString("fotoprofil");
                    String gusername = jsonObject.getString("username");
                    String gpassword = jsonObject.getString("password");
                    DetailPelanggan.this.nama.setText(gnama);
                    DetailPelanggan.this.nopelanggan.setText(gnopelanggan);
                    DetailPelanggan.this.nohp.setText(gnohp);
                    DetailPelanggan.this.alamat.setText(galamat);
                    DetailPelanggan.this.username.setText(gusername);
                    DetailPelanggan.this.password.setText(gpassword);
                    ((RequestBuilder) ((RequestBuilder) Glide.with(DetailPelanggan.this.getApplicationContext()).load(new Configurasi().baseUrl() + "public/img/" + gfotoprofil).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(DetailPelanggan.this.gambar);
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
                form.put(UploadTaskParameters.Companion.CodingKeys.id, DetailPelanggan.this.getIntent().getStringExtra("detail"));
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
