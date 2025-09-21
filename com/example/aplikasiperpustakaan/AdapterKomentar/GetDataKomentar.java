package com.example.aplikasiperpustakaan.AdapterKomentar;

public class GetDataKomentar {
    String foto_profil = "";
    int id = 0;
    String isi_komentar = "";
    String nama = "";

    public GetDataKomentar(int id2, String foto_profil2, String nama2, String isi_komentar2) {
        this.foto_profil = foto_profil2;
        this.nama = nama2;
        this.isi_komentar = isi_komentar2;
        this.id = id2;
    }

    public String getFoto_profil() {
        return this.foto_profil;
    }

    public String getNama() {
        return this.nama;
    }

    public String getIsi_komentar() {
        return this.isi_komentar;
    }

    public int getId() {
        return this.id;
    }
}
