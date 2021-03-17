package com.example.davidapp;

import android.content.Context;
import android.media.Image;

public class Item {
 public String nom;
  //  String prenom;
   public String phone;
   public   Image img;


    public Item(String nom, String phone,Image img) {
        this.nom = nom;
    //   this.img = img;
        this.phone = phone;
    }

    public Item() {
    }

}
