package com.example.davidapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class MyDatabase {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static String userId = "OjbxAtIbd53GVHtnhnVW";
    public final String TAG = "§§§";
    public CollectionReference collectionReferenceContacts = db.collection("users").document(userId).collection("contacts");
    public DocumentReference docRef = db.collection("cities").document("SF");

    public static ArrayList<Item> mArrayList = new ArrayList<Item>();

    public void addItems(Item item) {
        collectionReferenceContacts.add(item.toMap()).addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId())).addOnFailureListener(e -> Log.d(TAG, "Error 404: ", e));

    }

    public void updateItems(Item item) {
        collectionReferenceContacts.document(item.id).update(item.toMap()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot successfully written!");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }

    public ArrayList<Item> getItems() {
      //mArrayList.clear();
        collectionReferenceContacts.get()
                .addOnSuccessListener(documentSnapshots -> {
                    if (documentSnapshots.isEmpty()) {
                        Log.d(TAG, "onSuccess: LIST EMPTY");
                    } else {
                        List<Item> types = documentSnapshots.toObjects(Item.class);
                        mArrayList.addAll(types);
                        Log.d(TAG, "onSuccess: " + mArrayList.size());
                    }
                });
        return  mArrayList;
    }

}

