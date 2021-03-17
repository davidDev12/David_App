package com.example.davidapp;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LoadConact extends AsyncTask<Void,Void, ArrayList<String>> {


    @Override
    protected ArrayList<String> doInBackground(Void... voids) {
        return null;
    }
}
