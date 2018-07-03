package com.example.pkmara.activities.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity{

    public static final String MYPREFERENES = "MyPrefs";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editorPref;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(MYPREFERENES, Context.MODE_PRIVATE);
    }
}
