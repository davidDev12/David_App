package com.example.davidapp;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import com.google.firebase.storage.StorageReference;

import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.OnPausedListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




class MyDatabase {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static ArrayList<Item> marraylist = new ArrayList<Item>();
    public  ArrayList<Item> list;
    public static String userId = "mycontact";
    public final String TAG = "§§§";
    public CollectionReference collectionReferenceContacts = db.collection("Data");
    public DocumentReference docRef = db.collection("Data").document("mycontact");
    public String name;
    public String phone;
   //public ArrayList<Item> list;
        boolean ver;

    public MyDatabase() {
    }
    public MyDatabase(ArrayList<Item> list) {
        this.list = list;
        ver=true;
    }
    public MyDatabase(String name, String phone) {
        this.name = name;
        this.phone = phone;
        ver=false;
    }
    ///Ad_Items////////////////////////////////////////////////////////////////////////
    public void addItems() {
        if(ver==false) {
            Map<String, Object> user = new HashMap<>();
            user.put("name", name);
            user.put("phone", phone);
            collectionReferenceContacts.add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
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
            /*Item item = new Item(list);
            item.Convert();*/
            //HashMap<Item,Item> contac = convertArrayListToHashMap(list);
            db.collection("contact").add(list).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
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
    ///Update_Items/////////////////////////////////////////////////////////////////////////////

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
                Log.d(TAG, "Erreur 404: ",e);
            }});
    }
       /* private static HashMap<Item, Item> convertArrayListToHashMap(ArrayList<Item> arrayList) {
        HashMap<Item, Item> hashMap = new HashMap<>();
        for (Item str : arrayList) {
            hashMap.put(str, str);
        }
        return hashMap;*/
    /* public ArrayList<Item> getItems() {
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
    }*/
          public ArrayList<Item> getItems() {
           //    marraylist.removeAll(marraylist);
                collectionReferenceContacts.get()
                        .addOnSuccessListener(documentSnapshots -> {
                            if (documentSnapshots.isEmpty()) {
                                Log.d(TAG, "onSuccess: LIST EMPTY");
                            } else {
                                ArrayList<Item> types = (ArrayList<Item>) documentSnapshots.toObjects(Item.class);
                                marraylist.addAll(types);
                                Log.d(TAG, "onSuccess: " + marraylist.size());
                            }
                        });
              return  marraylist;
          }
    }
    ///Get_Items//////////////////////////////////////////////////////////////////////////////


