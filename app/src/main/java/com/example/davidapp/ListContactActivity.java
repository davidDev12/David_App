package com.example.davidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class ListContactActivity extends AppCompatActivity {
    ListView ls;
    ArrayList<Item> list;
    mAdapter mAdapter;
    MyDatabase myDatabase;
    Button save;
    ArrayList<String> itemStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        ls = findViewById(R.id.list2);
        list = new ArrayList<>();
        //  list.add(new Item("houcine",/*"daoud",*/"+212636520766"));
        //list.add(new Item("Mohamed",/*"daoud",*/"+212677560566"));
        // list.add(new Item("Ali",/*"daoud",*/"+212610748839"));
        // mAdapter = new mAdapter( getApplicationContext(),list);
        // ls.setAdapter(mAdapter);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(ListContactActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        }
      //  ls.setAdapter(mAdapter);
      //  save=findViewById(R.id.button5);
        /*save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase=new MyDatabase(list);} });*/
    }
    class loadContacts extends AsyncTask<Void, Void, ArrayList<Item>> {
        @Override
        protected ArrayList<Item> doInBackground(Void... voids) {
            list = new ArrayList<Item>();
            ArrayList Contacts = new ArrayList<String>();
            Cursor q = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            while (q.moveToNext()) {
                String nom = q.getString(q.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String num = q.getString(q.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
               // myDatabase=new MyDatabase(nom,num);
             //   myDatabase.addItems();
                list.add(new Item(nom, num));
                ///show
            }
            return list;
        }

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(ListContactActivity.this);
            pDialog.setTitle("Message");
            pDialog.setMessage("Please Wait ...");
            pDialog.show();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<Item> strings) {
            mAdapter = new mAdapter(getApplicationContext(), list);
            ls.setAdapter(mAdapter);
            pDialog.hide();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent activity = new Intent(this, ContactActivity.class);
                startActivity(activity);
                return true;
            case R.id.item4:
                this.finish();
                return true;
            case R.id.item3:
                try{myDatabase=new MyDatabase(list);
                myDatabase.addItems();
                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();} catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this,"Failed!!!",Toast.LENGTH_SHORT).show();
                }
                return  true;
            case R.id.item6:
                loadContacts load = new loadContacts();
                load.execute();
                return true;
            case R.id.item5:try {
                list = new ArrayList<>();
                myDatabase=new MyDatabase();
                list=myDatabase.getItems();
                mAdapter = new mAdapter(getApplicationContext(), list);
               // ls.setAdapter(mAdapter);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this,"Failed6666!!!",Toast.LENGTH_SHORT).show();
            }
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }

}