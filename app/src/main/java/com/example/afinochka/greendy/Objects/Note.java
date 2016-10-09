package com.example.afinochka.greendy.Objects;


import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class Note {

    private String title;
    private List images = new ArrayList<>();
    private String description;
    private String address;

    public Note(){}

    public Note(String title, List images, String description, String address){
        this.title = title;
        this.images = images;
        this.description = description;
        this.address = address;
    }

    public Note(String title, String address, List images){
        this.title = title;
        this.address = address;
        this.images = images;
    }

    public Note(String title, String description, String address){
        this.title = title;
        this.description = description;
        this.address = address;
    }

    public void setTitle(String title){this.title = title;}
    public String getTitle(){return title;}

    public void setImages(List images){this.images = images;}
    public List getImages(){return images;}

    public void setDescription(String description){this.description = description;}
    public String getDescription(){return description;}

    public void setAddress(String address){this.address = address;}
    public String getAddress(){return address;}
}
