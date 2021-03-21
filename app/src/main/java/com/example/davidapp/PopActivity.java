package com.example.davidapp;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

public class PopActivity extends DialogFragment implements View.OnClickListener {
   View view;
    EditText txtname,txtphone;
    MyDatabase myDatabase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.popactivity,
                container, false);
        Button popadd=(Button) view.findViewById(R.id.btnpopad);
        txtname=view.findViewById(R.id.namepop);
        txtphone=view.findViewById(R.id.phonepop);
        popadd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
        myDatabase=new MyDatabase(txtname.getText().toString(),txtphone.getText().toString());
        myDatabase.addItems();
        txtname.setText("");
        txtphone.setText("");

    }
}
