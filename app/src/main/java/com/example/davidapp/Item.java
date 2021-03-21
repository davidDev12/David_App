package com.example.davidapp;

import android.content.Context;
import android.media.Image;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import java.util.ArrayList;
import java.util.HashMap;

public class Item {
    public String name;
    public String phone;
    public Image image;
    public  ArrayList<Item> list;
    public Item(ArrayList<Item> list) {
        this.list = list;
    }
    public Item(String nom, String phone) {
        this.name = nom;
        this.phone = phone;
    }

    public Item() {
    }

    public Item(String nom, String phone, Image image) {
        this.name = nom;
        this.phone = phone;
        this.image=image;
    }
    /* private static HashMap<Item, Item> convertArrayListToHashMap(ArrayList<Item> arrayList) {
          HashMap<Item, Item> hashMap = new HashMap<>();
          for (Item str : arrayList) {
              hashMap.put(str, str);
          }
          return hashMap;
      }*/



   /* public HashMap<String, Object> Convert(){
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Item str : list) {

       //     hashMap.put(str,list.)
        }
      return hashMap;
    }*/
}
