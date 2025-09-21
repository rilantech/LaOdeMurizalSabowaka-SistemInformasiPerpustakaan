package com.example.aplikasiperpustakaan.AdapterDataPengembalianBuku;

public class GetDataPengembalianBuku {
    String batas_pinjam = "";
    int id = 0;
    String judul = "";
    String kode_buku = "";
    String mulai_pinjam = "";
    String nama_pengarang = "";
    String nomor = "";
    String waktu_kembali = "";

    public GetDataPengembalianBuku(int id2, String nomor2, String kode_buku2, String judul2, String nama_pengarang2, String mulai_pinjam2, String batas_pinjam2, String waktu_kembali2) {
        this.nomor = nomor2;
        this.kode_buku = kode_buku2;
        this.judul = judul2;
        this.nama_pengarang = nama_pengarang2;
        this.mulai_pinjam = mulai_pinjam2;
        this.batas_pinjam = batas_pinjam2;
        this.waktu_kembali = waktu_kembali2;
        this.id = id2;
    }

    public String getNomor() {
        return this.nomor;
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

    public String getMulai_pinjam() {
        return this.mulai_pinjam;
    }

    public String getBatas_pinjam() {
        return this.batas_pinjam;
    }

    public String getWaktu_kembali() {
        return this.waktu_kembali;
    }

    public Integer getId() {
        return Integer.valueOf(this.id);
    }
}
