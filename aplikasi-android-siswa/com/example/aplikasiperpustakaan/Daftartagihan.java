package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aplikasiperpustakaan.AdapterDataTagihan.AdaptorDataTagihan;
import com.example.aplikasiperpustakaan.AdapterDataTagihan.GetDataTagihan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Daftartagihan extends AppCompatActivity {
    AdaptorDataTagihan adaptordatatagihan;
    ListView listView;
    ArrayList<GetDataTagihan> model;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_daftartagihan);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.listView = (ListView) findViewById(R.id.list);
        load_data();
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Daftartagihan.this.getApplicationContext(), DetailTagihan.class);
                intent.putExtra("detail2", Daftartagihan.this.model.get(i).getId().toString());
                Daftartagihan.this.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void load_data() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "admin/tampil_data_tagihanclient.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONObject(response).getJSONArray("data");
                    Daftartagihan.this.model = new ArrayList<>();
                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject getData = jsonArray.getJSONObject(i);
                        Daftartagihan.this.model.add(new GetDataTagihan(getData.getInt(UploadTaskParameters.Companion.CodingKeys.id), getData.getString("tgl_bayar"), getData.getString("bulan"), getData.getString("penggunaan_air"), getData.getString("jumlah_bayar")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Daftartagihan.this.listView.setAdapter(new AdaptorDataTagihan(Daftartagihan.this.getApplicationContext(), Daftartagihan.this.model));
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> form = new HashMap<>();
                form.put("nopelanggan", String.valueOf(12345));
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
