package com.example.davidapp;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

public class active extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
