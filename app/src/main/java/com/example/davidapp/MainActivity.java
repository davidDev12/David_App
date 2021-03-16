package com.example.davidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    Button topAffich;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topAffich = findViewById(R.id.button3);
        topAffich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affiche();
            }
        });
    }

    public void affiche() {
        Intent activity = new Intent(MainActivity.this,ListContactActivity.class);
        Toast.makeText(this, "You clicked me", Toast.LENGTH_SHORT).show();

        startActivity(activity);
    }
}