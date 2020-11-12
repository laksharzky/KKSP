package com.example.laksha.kksp;

public class laporan {
    String reportId;
    String fullName;
    String gender;
    String tempatLahir;
    String tanggalLahir;
    String namaOrtu;
    String status;
    String pendidikan;
    String ketrampilan;




    public laporan(){

    }

    public laporan(String reportId, String fullName, String gender, String tempatLahir, String tanggalLahir, String namaOrtu, String status, String pendidikan, String ketrampilan) {
        this.reportId = reportId;
        this.fullName = fullName;
        this.gender = gender;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.namaOrtu = namaOrtu;
        this.status = status;
        this.pendidikan = pendidikan;
        this.ketrampilan = ketrampilan;
    }

    public String getReportId() {
        return reportId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public String getNamaOrtu() {
        return namaOrtu;
    }

    public String getStatus() {
        return status;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public String getKetrampilan() {
        return ketrampilan;
    }
}
