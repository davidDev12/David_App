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
        list = new ArrayList<>();
        //  list.add(new Item("houcine",/*"daoud",*/"+212636520766"));
        //list.add(new Item("Mohamed",/*"daoud",*/"+212677560566"));
        // list.add(new Item("Ali",/*"daoud",*/"+212610748839"));
        // mAdapter = new mAdapter( getApplicationContext(),list);
        // ls.setAdapter(mAdapter);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(ListContactActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
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
            ArrayList Contacts = new ArrayList<String>();
            Cursor q = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            while (q.moveToNext()) {
                String nom = q.getString(q.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String num = q.getString(q.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
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
            default:
                super.onOptionsItemSelected(item);

        }
        return true;
    }

}