package com.example.davidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "DocSnippets";

    Button add;
    Button show;
    ListView listView;
    EditText txtName, txtPhone;
    MyDatabase myDatabase;
    ArrayList<Item> items;
    ArrayList<String> itemStrings;
    mCustomAdapter itemsAdapter;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        add = findViewById(R.id.btnAdd);
        show = findViewById(R.id.btnShow);
        listView = findViewById(R.id.fbListView);
        txtName = findViewById(R.id.name);
        txtPhone = findViewById(R.id.phone);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase = new MyDatabase();
                final Item item = new Item(txtName.getText().toString(), txtPhone.getText().toString(), "mDavid/Contacts/pictures/Khalti.jpeg");
                myDatabase.addItems(item);
                txtName.getText().clear();
                txtPhone.getText().clear();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase = new MyDatabase();
                items = new ArrayList<>();
                itemStrings = new ArrayList<>();
                items = myDatabase.getItems();
                itemStrings.add("Noon");
                items.forEach(item -> itemStrings.add(item.name));
                //itemsAdapter = new mCustomAdapter(items, BaseActivity.this);
                arrayAdapter = new ArrayAdapter<String>(BaseActivity.this, android.R.layout.simple_list_item_1, itemStrings);
                listView.setAdapter(arrayAdapter);
            }
        });
    }

}