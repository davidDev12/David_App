package com.example.davidapp;

import android.content.Context;
import android.media.Image;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Item {
    public String id;
    public String name;
    public String phone;
    public String image;
    public Item(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Item(String name, String phone,String image) {
        this.name = name;
        this.phone = phone;
        this.image=image;
    }

    public Item(DocumentSnapshot documentSnapshot) {
        this.id=documentSnapshot.getId();
        this.name = Objects.requireNonNull(documentSnapshot.get("name")).toString();
        this.phone = Objects.requireNonNull(documentSnapshot.get("phone")).toString();;
        this.image = Objects.requireNonNull(documentSnapshot.get("image")).toString();;
    }
    public Map<String,Object> toMap(){
        HashMap<String,Object> mMap = new HashMap<>();
            mMap.put("name",name);
            mMap.put("phone",phone);
            mMap.put("image",image);
        return mMap;
    }
}
