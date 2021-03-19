package com.example.davidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidapp.Item;

import java.util.ArrayList;

class mCustomAdapter extends ArrayAdapter<Item> implements View.OnClickListener{

    private ArrayList<Item> items;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtPhone;
        TextView txtImage;
     
    }

    public mCustomAdapter(ArrayList<Item> data, Context context) {
        super(context, android.R.layout.simple_list_item_1, data);
        this.items = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Item item=(Item)object;

      
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.mlist_card, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.nameView);
            viewHolder.txtPhone = (TextView) convertView.findViewById(R.id.phoneView);
            //viewHolder.txtImage = (TextView) convertView.findViewById(R.id.imageView);
         

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

      
        lastPosition = position;

        viewHolder.txtName.setText(item.name);
        viewHolder.txtPhone.setText(item.phone);
        //viewHolder.txtImage.setText(item.getVersion_number());
        
        return convertView;
    }
}
