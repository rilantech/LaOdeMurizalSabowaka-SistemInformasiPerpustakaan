package com.example.aplikasiperpustakaan.AdapterDataPengembalianBuku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.aplikasiperpustakaan.R;
import java.util.ArrayList;

public class AdaptorDataPengembalianBuku extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<GetDataPengembalianBuku> model;

    public AdaptorDataPengembalianBuku(Context context2, ArrayList<GetDataPengembalianBuku> model2) {
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
        View view1 = this.inflater.inflate(R.layout.list_pengembalian_buku, (ViewGroup) null);
        if (view1 != null) {
            ((TextView) view1.findViewById(R.id.nomor)).setText(this.model.get(position).getNomor());
            ((TextView) view1.findViewById(R.id.kode_buku)).setText(this.model.get(position).getKode_buku());
            ((TextView) view1.findViewById(R.id.judul)).setText(this.model.get(position).getJudul());
            ((TextView) view1.findViewById(R.id.nama_pengarang)).setText(this.model.get(position).getNama_pengarang());
            ((TextView) view1.findViewById(R.id.mulai_pinjam)).setText(this.model.get(position).getMulai_pinjam());
            ((TextView) view1.findViewById(R.id.batas_pinjam)).setText(this.model.get(position).getBatas_pinjam());
            ((TextView) view1.findViewById(R.id.waktu_kembali)).setText(this.model.get(position).getWaktu_kembali());
        }
        return view1;
    }
}
