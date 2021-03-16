package com.example.davidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    ArrayList< Item> items;
    Context context;
    LayoutInflater inflater;
    public MonAdapter(ArrayList<Item> item, Context context) {
        this.items = item;
        this.context = context;
        inflater = (LayoutInflater.from(context));
    }

   

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView= inflater.inflate(R.layout.layouto,null);

        TextView nom=(TextView)convertView.findViewById(R.id.nomxml);
        TextView phone=(TextView)convertView.findViewById(R.id.phonexml);

        nom.setText(items.get(position).nom);
        phone.setText(items.get(position).phone);

        //TextView prenom=(TextView)convertView.findViewById(R.id.nom);
        return convertView;
    }
}
