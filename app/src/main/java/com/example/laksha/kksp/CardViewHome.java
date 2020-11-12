package com.example.laksha.kksp;

public class CardViewHome {

    private int Photo;
    private String Judul;
    private String Isi;

    public CardViewHome(){

    }

    public CardViewHome(int photo, String judul, String isi) {
        Photo = photo;
        Judul = judul;
       Isi = isi;
    }

    public int getPhoto() {
        return Photo;
    }

    public String getJudul() {
        return Judul;
    }

    public String getIsi() {
        return Isi;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public void setIsi(String isi) {
        Isi = isi;
    }
}