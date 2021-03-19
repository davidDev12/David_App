package com.example.davidapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class MyDatabase {

    public String name;
    public String phone;
    ArrayList<Item> list;
        boolean ver;
    public MyDatabase(ArrayList<Item> list) {
        this.list = list;
        ver=true;
    }

    public MyDatabase(String name, String phone) {
        this.name = name;
        this.phone = phone;
        ver=false;
    }

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public final String TAG = "David";

    public void addItems() {
        if(ver==false) {
            Map<String, Object> user = new HashMap<>();
            user.put("name", name);
            user.put("phone", phone);
            db.collection("user").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG, "Erreur 404: ", e);
                }
            });
        }
        else{
            HashMap<Item,Item> contac = convertArrayListToHashMap(list);
            db.collection("contact").add(contac).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG, "Erreur 404: ", e);
                }
            });
        }
    }

    private static HashMap<Item, Item> convertArrayListToHashMap(ArrayList<Item> arrayList) {
        HashMap<Item, Item> hashMap = new HashMap<>();
        for (Item str : arrayList) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public void updateITems() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "txtname");
        user.put("phone", "txtphone");
        db.collection("user").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                //  Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Log.d(TAG, "Erreur 404: ",e);
            }
        });

    }

    public void getItems() {
        DocumentReference docRef = db.collection("cities").document("SF");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    assert document != null;
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

    }
}
