package com.example.aplikasiperpustakaan.AdapterAbsen;

public class GetDataAbsen {
    int id = 0;
    String jam_masuk = "";
    String jam_pulang = "";
    String tgl = "";

    public GetDataAbsen(int id2, String tgl2, String jam_masuk2, String jam_pulang2) {
        this.tgl = tgl2;
        this.jam_masuk = jam_masuk2;
        this.jam_pulang = jam_pulang2;
        this.id = id2;
    }

    public Integer getId() {
        return Integer.valueOf(this.id);
    }

    public String getTgl() {
        return this.tgl;
    }

    public String getJam_masuk() {
        return this.jam_masuk;
    }

    public String getJam_pulang() {
        return this.jam_pulang;
    }
}
