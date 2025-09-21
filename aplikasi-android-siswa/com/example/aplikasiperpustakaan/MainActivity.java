package com.example.aplikasiperpustakaan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aplikasiperpustakaan.Adapter.Adaptor;
import com.example.aplikasiperpustakaan.Adapter.GetData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Adaptor adaptor;
    ListView listView;
    ArrayList<GetData> model;
    Button tambah_data;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
