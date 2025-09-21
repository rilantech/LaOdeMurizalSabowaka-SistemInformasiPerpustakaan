package com.example.aplikasiperpustakaan.AdapterAbsen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.aplikasiperpustakaan.R;
import java.util.ArrayList;

public class AdaptorAbsen extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<GetDataAbsen> model;

    public AdaptorAbsen(Context context2, ArrayList<GetDataAbsen> model2) {
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
        View view1 = this.inflater.inflate(R.layout.list_absen, (ViewGroup) null);
        if (view1 != null) {
            TextView absenmasuk = (TextView) view1.findViewById(R.id.absenmasuk);
            TextView absenpulang = (TextView) view1.findViewById(R.id.absenpulang);
            absenmasuk.setText("Belum Absen");
            absenpulang.setText("Belum Absen");
            ((TextView) view1.findViewById(R.id.tanggal)).setText(this.model.get(position).getTgl());
            absenmasuk.setText(this.model.get(position).getJam_masuk());
            absenpulang.setText(this.model.get(position).getJam_pulang());
        }
        return view1;
    }
}
