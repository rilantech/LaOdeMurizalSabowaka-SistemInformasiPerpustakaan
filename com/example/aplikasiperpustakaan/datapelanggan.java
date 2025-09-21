package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.aplikasiperpustakaan.AdapterDataPelanggan.AdaptorDataPelanggan;
import com.example.aplikasiperpustakaan.AdapterDataPelanggan.GetDataPelanggan;
import java.util.ArrayList;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class datapelanggan extends AppCompatActivity {
    AdaptorDataPelanggan adaptordatapelanggan;
    ListView listView;
    ArrayList<GetDataPelanggan> model;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_datapelanggan);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.listView = (ListView) findViewById(R.id.list);
        load_data2();
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                PopupMenu popupMenu = new PopupMenu(datapelanggan.this.getApplicationContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_detail, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.detail) {
                            Intent intent = new Intent(datapelanggan.this.getApplicationContext(), DetailPelanggan.class);
                            intent.putExtra("detail", datapelanggan.this.model.get(i).getId().toString());
                            datapelanggan.this.startActivity(intent);
                            return false;
                        } else if (menuItem.getItemId() != R.id.tambah) {
                            return false;
                        } else {
                            Intent intent2 = new Intent(datapelanggan.this.getApplicationContext(), Tambahtagihan.class);
                            intent2.putExtra("tambah", datapelanggan.this.model.get(i).getId().toString());
                            datapelanggan.this.startActivity(intent2);
                            return false;
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void load_data2() {
        new StringRequest(1, new Configurasi().baseUrl() + "admin/tampil_data_pelanggan.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONObject(response).getJSONArray("data");
                    datapelanggan.this.model = new ArrayList<>();
                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject getData = jsonArray.getJSONObject(i);
                        datapelanggan.this.model.add(new GetDataPelanggan(getData.getInt(UploadTaskParameters.Companion.CodingKeys.id), getData.getString("nama"), getData.getString("nopelanggan"), getData.getString("alamat")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                datapelanggan.this.listView.setAdapter(new AdaptorDataPelanggan(datapelanggan.this.getApplicationContext(), datapelanggan.this.model));
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
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
