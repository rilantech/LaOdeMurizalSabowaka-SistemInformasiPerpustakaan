package com.example.aplikasiperpustakaan.AdapterDataBerita;

public class GetDataBerita {
    int id = 0;
    String nama = "";
    String nopelanggan = "";

    public GetDataBerita(int id2, String nopelanggan2, String nama2) {
        this.nopelanggan = nopelanggan2;
        this.nama = nama2;
        this.id = id2;
    }

    public String getNopelanggan() {
        return this.nopelanggan;
    }

    public String getNama() {
        return this.nama;
    }

    public Integer getId() {
        return Integer.valueOf(this.id);
    }
}
