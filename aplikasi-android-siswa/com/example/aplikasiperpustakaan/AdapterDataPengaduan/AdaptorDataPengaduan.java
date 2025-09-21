package com.example.aplikasiperpustakaan.AdapterDataPengaduan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.aplikasiperpustakaan.R;
import java.util.ArrayList;

public class AdaptorDataPengaduan extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<GetDataPengaduan> model;

    public AdaptorDataPengaduan(Context context2, ArrayList<GetDataPengaduan> model2) {
        this.inflater = LayoutInflater.from(context2);
        this.context = context2;
        this.model = model2;
    }

    public int getCount() {
        return this.model.size();
    }

    public Object getItem(int position) {
        return this.model.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        View view1 = this.inflater.inflate(R.layout.list_pengaduan, (ViewGroup) null);
        if (view1 != null) {
            ((TextView) view1.findViewById(R.id.nomorpelanggan)).setText(this.model.get(position).getNopelanggan());
            ((TextView) view1.findViewById(R.id.nama)).setText(this.model.get(position).getNama());
        }
        return view1;
    }
}
