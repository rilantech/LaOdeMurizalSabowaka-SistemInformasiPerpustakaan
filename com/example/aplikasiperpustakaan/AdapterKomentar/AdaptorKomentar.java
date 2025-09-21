package com.example.aplikasiperpustakaan.AdapterKomentar;

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

public class AdaptorKomentar extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<GetDataKomentar> model;

    public AdaptorKomentar(Context context2, ArrayList<GetDataKomentar> model2) {
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
        View view1 = this.inflater.inflate(R.layout.list_komentar, (ViewGroup) null);
        if (view1 != null) {
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(this.context).load(new Configurasi().baseUrl() + "public/img/" + this.model.get(position).getFoto_profil()).circleCrop()).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into((ImageView) view1.findViewById(R.id.foto_profil));
            ((TextView) view1.findViewById(R.id.nama)).setText(this.model.get(position).getNama());
            ((TextView) view1.findViewById(R.id.isi_komentar)).setText(this.model.get(position).getIsi_komentar());
        }
        return view1;
    }
}
