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


    Button add;
    EditText txtname,txtphone;
    MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        add=findViewById(R.id.btnAdd);
        txtname=findViewById(R.id.name);
        txtphone=findViewById(R.id.phone);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase=new MyDatabase(txtname.getText().toString(),txtphone.getText().toString());
                myDatabase.addItems();
                txtname.setText("");
                txtphone.setText("");

            }
        });
    }

}