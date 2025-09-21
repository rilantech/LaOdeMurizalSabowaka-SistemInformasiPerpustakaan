package com.example.aplikasiperpustakaan.Adapter;

public class GetData {
    String alamat = "";
    String email = "";
    String gambar = "";
    int id = 0;
    String nama = "";
    String nip = "";

    public GetData(int id2, String gambar2, String nama2, String email2, String nip2, String alamat2) {
        this.gambar = gambar2;
        this.nama = nama2;
        this.email = email2;
        this.nip = nip2;
        this.alamat = alamat2;
        this.id = id2;
    }

    public Integer getId() {
        return Integer.valueOf(this.id);
    }

    public String getGambar() {
        return this.gambar;
    }

    public String getNama() {
        return this.nama;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNip() {
        return this.nip;
    }

    public String getAlamat() {
        return this.alamat;
    }
}
