package com.example.aplikasiperpustakaan.AdapterDataBuku;

public class GetDataBuku {
    int id = 0;
    String judul = "";
    String kode_buku = "";
    String letak_buku = "";
    String nama_pengarang = "";
    String penerbit_atau_tahun_terbit = "";
    String sampul = "";

    public GetDataBuku(int id2, String sampul2, String kode_buku2, String judul2, String nama_pengarang2, String penerbit_atau_tahun_terbit2, String letak_buku2) {
        this.sampul = sampul2;
        this.kode_buku = kode_buku2;
        this.judul = judul2;
        this.nama_pengarang = nama_pengarang2;
        this.penerbit_atau_tahun_terbit = penerbit_atau_tahun_terbit2;
        this.letak_buku = letak_buku2;
        this.id = id2;
    }

    public String getSampul() {
        return this.sampul;
    }

    public String getKode_buku() {
        return this.kode_buku;
    }

    public String getJudul() {
        return this.judul;
    }

    public String getNama_pengarang() {
        return this.nama_pengarang;
    }

    public String getPenerbit_atau_tahun_terbit() {
        return this.penerbit_atau_tahun_terbit;
    }

    public String getLetak_buku() {
        return this.letak_buku;
    }

    public Integer getId() {
        return Integer.valueOf(this.id);
    }
}
