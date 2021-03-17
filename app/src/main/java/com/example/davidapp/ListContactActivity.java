package com.example.davidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
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
     //  list.add(new Item("houcine",/*"daoud",*/"+212636520766"));
        //list.add(new Item("Mohamed",/*"daoud",*/"+212677560566"));
       // list.add(new Item("Ali",/*"daoud",*/"+212610748839"));
       // mAdapter = new mAdapter( getApplicationContext(),list);
      // ls.setAdapter(mAdapter);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)== PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(ListContactActivity.this, new String[]{Manifest.permission.READ_CONTACTS},1);
        }
        loadContacts load = new loadContacts();
        load.execute();
        // The contacts from the contacts content provider is stored in this
        // cursor
     //   MatrixCursor = new MatrixCursor(new String[] { "_id", "name", "photo",
      //          "details" });
      //  ls.setAdapter(mAdapter);

    }


    class loadContacts extends AsyncTask<Void, Void, ArrayList<Item>> {

        @Override
        protected ArrayList<Item> doInBackground(Void... voids) {
            list = new ArrayList<Item>();
          //  ArrayList Contacts = new ArrayList<String>();
            Cursor q = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            while(q.moveToNext()){
                String nom = q.getString(q.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String num = q.getString(q.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                list.add(new Item(nom,num));

                //list.add(new itemnom+" : "+ num);

            }
            return  list;
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
            mAdapter = new mAdapter( getApplicationContext(), list);

          // ArrayAdapter<String> adap = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,strings);
            ls.setAdapter(mAdapter);
            pDialog.hide();
        }
    }
}