package com.example.aplikasiperpustakaan.AdapterDataBuku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.aplikasiperpustakaan.Configurasi;
import com.example.aplikasiperpustakaan.R;
import java.util.ArrayList;

public class AdaptorDataBuku extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<GetDataBuku> model;

    public AdaptorDataBuku(Context context2, ArrayList<GetDataBuku> model2) {
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
        View view1 = this.inflater.inflate(R.layout.list_data_buku, (ViewGroup) null);
        if (view1 != null) {
            ((TextView) view1.findViewById(R.id.kode_buku)).setText(this.model.get(position).getKode_buku());
            ((TextView) view1.findViewById(R.id.judul)).setText(this.model.get(position).getJudul());
            ((TextView) view1.findViewById(R.id.nama_pengarang)).setText(this.model.get(position).getNama_pengarang());
            ((TextView) view1.findViewById(R.id.penerbit_atau_tahun_terbit)).setText(this.model.get(position).getPenerbit_atau_tahun_terbit());
            ((TextView) view1.findViewById(R.id.letak_buku)).setText(this.model.get(position).getLetak_buku());
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.context).load(new Configurasi().baseUrl() + "public/img/" + this.model.get(position).getSampul()).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into((ImageView) view1.findViewById(R.id.sampul));
        }
        return view1;
    }
}
