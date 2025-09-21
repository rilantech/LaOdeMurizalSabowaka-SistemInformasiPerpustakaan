package com.example.aplikasiperpustakaan.AdapterDataTagihan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class AdaptorDataTagihan extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<GetDataTagihan> model;

    public AdaptorDataTagihan(Context context2, ArrayList<GetDataTagihan> model2) {
        this.inflater = LayoutInflater.from(context2);
        this.context = context2;
        this.model = model2;
    }

    public int getCount() {
        return 0;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
