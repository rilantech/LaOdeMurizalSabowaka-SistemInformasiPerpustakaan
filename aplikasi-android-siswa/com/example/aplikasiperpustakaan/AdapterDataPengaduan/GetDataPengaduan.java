package com.example.aplikasiperpustakaan.AdapterDataPengaduan;

public class GetDataPengaduan {
    int id = 0;
    String nama = "";
    String nopelanggan = "";

    public GetDataPengaduan(int id2, String nopelanggan2, String nama2) {
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
