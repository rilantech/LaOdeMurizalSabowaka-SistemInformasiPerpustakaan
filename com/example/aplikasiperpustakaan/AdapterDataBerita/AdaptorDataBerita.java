package com.example.aplikasiperpustakaan.AdapterDataBerita;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.aplikasiperpustakaan.R;
import java.util.ArrayList;

public class AdaptorDataBerita extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<GetDataBerita> model;

    public AdaptorDataBerita(Context context2, ArrayList<GetDataBerita> model2) {
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
        View view1 = this.inflater.inflate(R.layout.list_berita, (ViewGroup) null);
        if (view1 != null) {
            TextView textView = (TextView) view1.findViewById(R.id.judul);
            TextView textView2 = (TextView) view1.findViewById(R.id.isiberita);
            ImageView imageView = (ImageView) view1.findViewById(R.id.gambar);
        }
        return view1;
    }
}
