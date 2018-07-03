package com.example.pkmara.activities.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.pkmara.activities.view.MainActivityViewImpl;
import com.example.pkmara.models.OrderJSON;

public class MainActivity extends AppCompatActivity {
    MainActivityViewImpl mMainActivityView;
    public static OrderJSON mOrderJSON;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mMainActivityView = new MainActivityViewImpl(this, null);
        setContentView(mMainActivityView.getRootView());
    }

    public void openActivity2(View v){
        mOrderJSON = new OrderJSON(mMainActivityView.getNama(), 1);
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
