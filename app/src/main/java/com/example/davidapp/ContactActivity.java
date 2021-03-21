package com.example.davidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {
    EditText txtname,txtphone;
    MyDatabase myDatabase;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        add=findViewById(R.id.btnsave);
        txtname=findViewById(R.id.nom);
        txtphone=findViewById(R.id.numero);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase=new MyDatabase(txtname.getText().toString(),txtphone.getText().toString());
                myDatabase.addItems();
                txtname.setText("");
                txtphone.setText("");
               finish();
            }
        });
    }

    public void affiche(View view) {

        Intent activity = new Intent(this,ListContactActivity.class);
        startActivity(activity);
    }

}