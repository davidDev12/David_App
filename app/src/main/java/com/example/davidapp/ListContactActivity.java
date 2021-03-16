package com.example.davidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListContactActivity extends AppCompatActivity {
    ListView ls;
    ArrayList<Item> list;
    mAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        ls = findViewById(R.id.list2);
        list = new ArrayList<Item>();
        list.add(new Item("houcine",/*"daoud",*/"+212636520766"));
        list.add(new Item("Mohamed",/*"daoud",*/"+212677560566"));
        list.add(new Item("Ali",/*"daoud",*/"+212610748839"));
        mAdapter = new mAdapter( getApplicationContext(),list);
       ls.setAdapter(mAdapter);

      //  ls.setAdapter(mAdapter);

    }

}