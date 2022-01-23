package com.example.uas_180030459.model;

import com.google.gson.annotations.SerializedName;

public class Music {

    @SerializedName("id")
    private int id;
    @SerializedName("judul_lagu")
    private String judulLagu;
    @SerializedName("nama_penyanyi")
    private String namaPenyanyi;
    @SerializedName("album")
    private String album;
    @SerializedName("tahun")
    private String tahun;
    @SerializedName("photo")
    private String photo;
    @SerializedName("genre")
    private String genre;

    public Music(int id, String judulLagu, String namaPenyanyi, String album, String tahun, String photo, String genre) {
        this.id = id;
        this.judulLagu = judulLagu;
        this.namaPenyanyi = namaPenyanyi;
        this.album = album;
        this.tahun = tahun;
        this.photo = photo;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getJudulLagu() {
        return judulLagu;
    }

    public String getNamaPenyanyi() {
        return namaPenyanyi;
    }

    public String getAlbum() {
        return album;
    }

    public String getTahun() {
        return tahun;
    }

    public String getPhoto() {
        return photo;
    }

    public String getGenre() {
        return genre;
    }
}
