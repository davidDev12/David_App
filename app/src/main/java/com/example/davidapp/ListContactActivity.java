package com.example.davidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListContactActivity extends AppCompatActivity {
ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        ArrayList<Item> list=new   ArrayList<Item>();
        list.add(new Item("houcine",/*"daoud",*/"+212636520766"));
        list.add(new Item("Mohamed",/*"daoud",*/"+212677560566"));
        list.add(new Item("Ali",/*"daoud",*/"+212610748839"));
    MonAdapter monadapter = new MonAdapter(list,this);
    ls=findViewById(R.id.list2);
    ls.setAdapter(monadapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mymenu = getMenuInflater();
        mymenu.inflate(R.menu.menu, menu);
        // this is good
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:   Intent activity = new Intent(this,ContactActivity.class);
                startActivity(activity);
                return true;
            default:return  super.onOptionsItemSelected(item);
        }
    }
}