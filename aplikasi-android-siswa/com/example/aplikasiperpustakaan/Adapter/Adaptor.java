package com.example.aplikasiperpustakaan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.aplikasiperpustakaan.R;
import java.util.ArrayList;

public class Adaptor extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<GetData> model;

    public Adaptor(Context context2, ArrayList<GetData> model2) {
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
        View view1 = this.inflater.inflate(R.layout.list_guru, (ViewGroup) null);
        if (view1 != null) {
            ((TextView) view1.findViewById(R.id.gambar)).setText(this.model.get(position).getGambar());
            ((TextView) view1.findViewById(R.id.nama)).setText(this.model.get(position).getNama());
            ((TextView) view1.findViewById(R.id.email)).setText(this.model.get(position).getEmail());
            ((TextView) view1.findViewById(R.id.nip)).setText(this.model.get(position).getNip());
            ((TextView) view1.findViewById(R.id.alamat)).setText(this.model.get(position).getAlamat());
        }
        return view1;
    }
}
