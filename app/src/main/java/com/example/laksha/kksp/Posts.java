package com.example.laksha.kksp;

public class Posts {

    private String Images;
    private String Titles;
    private String Details;

    public Posts() {

    }

    public Posts(String images, String titles, String details) {
        Images = images;
        Titles = titles;
        Details = details;
    }
//Getter
    public String getImages() {
        return Images;
    }

    public String getTitles() {
        return Titles;
    }

    public String getDetails() {
        return Details;
    }
//Setter
    public void setImages(String images) {
        Images = images;
    }

    public void setTitles(String titles) {
        Titles = titles;
    }

    public void setDetails(String details) {
        Details = details;
    }
}
