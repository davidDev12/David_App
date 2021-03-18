package com.example.davidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG ="DocSnippets" ;
    FirebaseFirestore db;
    Button add;
    EditText txtname,txtphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
     db   = FirebaseFirestore.getInstance();
        add=findViewById(R.id.btnAdd);
        txtname=findViewById(R.id.name);
        txtname=findViewById(R.id.phone);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database();
            }
        });
    }
    public  void database(){
        Map<String, Object> user = new HashMap<>();
        user.put("name", txtname);
        user.put("phone",txtphone);
       // user.put("born", 1815);
        db.collection("user").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {


            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Erreur 404: ",e);
            }
        });

    }
}