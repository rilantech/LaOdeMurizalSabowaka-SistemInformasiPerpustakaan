package com.example.aplikasiperpustakaan.AdapterDataPelanggan;

public class GetDataPelanggan {
    String alamat = "";
    int id = 0;
    String nama = "";
    String nopelanggan = "";

    public GetDataPelanggan(int id2, String nama2, String nopelanggan2, String alamat2) {
        this.nama = nama2;
        this.nopelanggan = nopelanggan2;
        this.alamat = alamat2;
        this.id = id2;
    }

    public String getNama() {
        return this.nama;
    }

    public String getNopelanggan() {
        return this.nopelanggan;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public Integer getId() {
        return Integer.valueOf(this.id);
    }
}
