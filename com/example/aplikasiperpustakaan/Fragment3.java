package com.example.aplikasiperpustakaan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    ImageView gambar1;
    TextView tvAlamat;
    TextView tvEmail;
    TextView tvNama;
    TextView tvNip;
    TextView tvPassword;
    TextView tvUsername;
    TextView tvUuid;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        this.tvNip = (TextView) view.findViewById(R.id.tvNip);
        this.tvNama = (TextView) view.findViewById(R.id.tvNama);
        this.tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        this.tvAlamat = (TextView) view.findViewById(R.id.tvAlamat);
        this.tvUsername = (TextView) view.findViewById(R.id.tvUsername);
        this.tvPassword = (TextView) view.findViewById(R.id.tvPassword);
        this.tvUuid = (TextView) view.findViewById(R.id.tvUuid);
        this.gambar1 = (ImageView) view.findViewById(R.id.gambar1);
        return view;
    }
}
