package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aplikasiperpustakaan.AdapterDataPengaduan.AdaptorDataPengaduan;
import com.example.aplikasiperpustakaan.AdapterDataPengaduan.GetDataPengaduan;
import java.util.ArrayList;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Daftarpengaduan extends AppCompatActivity {
    AdaptorDataPengaduan adaptorDataPengaduan;
    ListView listView;
    ArrayList<GetDataPengaduan> model;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_daftarpengaduan);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.listView = (ListView) findViewById(R.id.list);
        load_data2();
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Daftarpengaduan.this.getApplicationContext(), DetailPengaduan.class);
                intent.putExtra("detail2", Daftarpengaduan.this.model.get(i).getId().toString());
                Daftarpengaduan.this.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void load_data2() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "admin/tampil_data_pengaduan.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONObject(response).getJSONArray("data");
                    Daftarpengaduan.this.model = new ArrayList<>();
                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject getData = jsonArray.getJSONObject(i);
                        Daftarpengaduan.this.model.add(new GetDataPengaduan(getData.getInt(UploadTaskParameters.Companion.CodingKeys.id), getData.getString("nopelanggan"), getData.getString("nama")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Daftarpengaduan.this.listView.setAdapter(new AdaptorDataPengaduan(Daftarpengaduan.this.getApplicationContext(), Daftarpengaduan.this.model));
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }));
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
