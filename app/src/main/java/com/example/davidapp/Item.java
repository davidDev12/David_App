package com.example.davidapp;

import android.content.Context;
import android.media.Image;

public class Item {




    public String name;
    public String phone;
    public Image image;
    public Item(String nom, String phone) {
        this.name = nom;
        this.phone = phone;
    }

    public Item(String nom, String phone,Image image) {
        this.name = nom;
        this.phone = phone;
        this.image=image;
    }
}
