package com.example.aplikasiperpustakaan.AdapterDataTagihan;

public class GetDataTagihan {
    String bulan = "";
    int id = 0;
    String jumlah_bayar = "";
    String penggunaan_air = "";
    String tgl_bayar = "";

    public GetDataTagihan(int id2, String tgl_bayar2, String bulan2, String penggunaan_air2, String jumlah_bayar2) {
        this.tgl_bayar = tgl_bayar2;
        this.bulan = bulan2;
        this.jumlah_bayar = jumlah_bayar2;
        this.penggunaan_air = penggunaan_air2;
        this.jumlah_bayar = jumlah_bayar2;
        this.id = id2;
    }

    public String getTgl_bayar() {
        return this.tgl_bayar;
    }

    public String getBulan() {
        return this.bulan;
    }

    public String getPenggunaan_air() {
        return this.penggunaan_air;
    }

    public String getJumlah_bayar() {
        return this.jumlah_bayar;
    }

    public Integer getId() {
        return Integer.valueOf(this.id);
    }
}
