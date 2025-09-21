package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    Button tomboldatapelanggan;
    Button tombolpengaduan;
    Button tomboltagihan;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        this.tomboltagihan = (Button) view.findViewById(R.id.tomboltagihan);
        this.tombolpengaduan = (Button) view.findViewById(R.id.tombolpengaduan);
        this.tomboltagihan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment1.this.startActivity(new Intent(Fragment1.this.getContext(), Daftartagihan.class));
            }
        });
        this.tombolpengaduan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment1.this.startActivity(new Intent(Fragment1.this.getContext(), Daftarpengaduan.class));
            }
        });
        return view;
    }
}
