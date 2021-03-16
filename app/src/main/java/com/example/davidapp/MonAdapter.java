package com.example.davidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    ArrayList< Item> item;
    Context context;

    public MonAdapter(ArrayList<Item> item, Context context) {
        this.item = item;
        this.context = context;
    }

   

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {

        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView=LayoutInflater.from(context).inflate(R.layout.lay1,null);

        TextView nom=(TextView)convertView.findViewById(R.id.nomxml);
        TextView phone=(TextView)convertView.findViewById(R.id.phonexml);

        nom.setText(item.get(position).nom);

        phone.setText(item.get(position).phone);

        //TextView prenom=(TextView)convertView.findViewById(R.id.nom);
        return convertView;
    }
}
