package com.example.aplikasiperpustakaan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Profil extends Fragment {
    ImageView foto;
    TextView tvJurusan;
    TextView tvKelas;
    TextView tvNama;
    TextView tvNis;
    TextView tvNomorhp;
    TextView tvPassword;
    TextView tvUsername;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.halaman_profil, (ViewGroup) null);
        this.tvNama = (TextView) view.findViewById(R.id.tvNama);
        this.tvNis = (TextView) view.findViewById(R.id.tvNis);
        this.tvKelas = (TextView) view.findViewById(R.id.tvKelas);
        this.tvJurusan = (TextView) view.findViewById(R.id.tvJurusan);
        this.tvNomorhp = (TextView) view.findViewById(R.id.tvNomorhp);
        this.tvUsername = (TextView) view.findViewById(R.id.tvUsername);
        this.tvPassword = (TextView) view.findViewById(R.id.tvPassword);
        this.foto = (ImageView) view.findViewById(R.id.foto);
        ((RequestBuilder) ((RequestBuilder) Glide.with((Fragment) this).load(new Configurasi().baseUrl() + "public/img/" + HalamanLogin.foto).diskCacheStrategy(DiskCacheStrategy.NONE)).skipMemoryCache(true)).into(this.foto);
        this.tvNama.setText(HalamanLogin.nama);
        this.tvNis.setText(HalamanLogin.nis);
        this.tvKelas.setText(HalamanLogin.kelas);
        this.tvJurusan.setText(HalamanLogin.jurusan);
        this.tvNomorhp.setText(HalamanLogin.nomorhp);
        this.tvUsername.setText(HalamanLogin.username);
        this.tvPassword.setText(HalamanLogin.password);
        return view;
    }
}
