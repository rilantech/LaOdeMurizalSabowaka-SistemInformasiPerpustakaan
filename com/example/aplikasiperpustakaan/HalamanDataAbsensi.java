package com.example.aplikasiperpustakaan;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aplikasiperpustakaan.AdapterAbsen.AdaptorAbsen;
import com.example.aplikasiperpustakaan.AdapterAbsen.GetDataAbsen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HalamanDataAbsensi extends AppCompatActivity {
    AdaptorAbsen adaptorabsen;
    ListView listView;
    ArrayList<GetDataAbsen> model;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_halaman_data_absensi);
        this.listView = (ListView) findViewById(R.id.list);
        load_data();
    }

    /* access modifiers changed from: package-private */
    public void load_data() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "api/tampil_data_absen.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONObject(response).getJSONArray("data");
                    HalamanDataAbsensi.this.model = new ArrayList<>();
                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject getData = jsonArray.getJSONObject(i);
                        HalamanDataAbsensi.this.model.add(new GetDataAbsen(getData.getInt(UploadTaskParameters.Companion.CodingKeys.id), getData.getString("tgl"), getData.getString("jam_masuk"), getData.getString("jam_pulang")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                HalamanDataAbsensi.this.listView.setAdapter(new AdaptorAbsen(HalamanDataAbsensi.this.getApplicationContext(), HalamanDataAbsensi.this.model));
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() throws AuthFailureError {
                return new HashMap<>();
            }
        });
    }
}
