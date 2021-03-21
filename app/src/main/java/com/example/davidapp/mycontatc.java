package com.example.davidapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import java.util.ArrayList;

import static com.activeandroid.Cache.getContext;

public class mycontatc extends AsyncTask<Void, Void, ArrayList<Item>> {

    public ArrayList<Item> list;

    public mycontatc(ArrayList<Item> list) {
        this.list = list;
    }

    ContentResolver cr = getActivity().getContentResolver();
    @Override
    public ArrayList<Item> doInBackground(Void... voids) {
        //list = new ArrayList<Item>();
        ArrayList Contacts = new ArrayList<String>();
        Cursor q = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
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

   /* ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog();
        pDialog.setTitle("Message");
        pDialog.setMessage("Please Wait ...");
        pDialog.show();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ArrayList<Item> strings) {

        pDialog.hide();
    }*/
   public Activity getActivity() {
        Context context = getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }
}
