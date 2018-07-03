package com.example.pkmara.activities.presenter;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.pkmara.R;
import com.example.pkmara.activities.view.MenuDetailActivityViewImpl;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.r0adkll.slidr.model.SlidrPosition;


public class MenuDetailActivity extends AppCompatActivity {
    MenuDetailActivityViewImpl mMenuDetailActivityViewImp;
    private SlidrInterface slidr;
    private SlidrConfig slidrConfig;
    String menuName;
    int price;

    protected void onCreate (Bundle savedInstanceState){
        menuName = getIntent().getStringExtra("MENU_NAME");
        super.onCreate(savedInstanceState);
        mMenuDetailActivityViewImp = new MenuDetailActivityViewImpl(this, null, menuName);
        setContentView(mMenuDetailActivityViewImp.getRootView());
        int primaryColor = getResources().getColor(R.color.primaryDark);
        int secondaryColor = getResources().getColor(R.color.colorAccent);
        slidrConfig = new SlidrConfig.Builder()
                .primaryColor(primaryColor)
                .secondaryColor(secondaryColor)
                .position(SlidrPosition.LEFT)
                .scrimColor(Color.BLACK)
                .scrimStartAlpha(0.8f)
                .scrimEndAlpha(0f)
                .distanceThreshold(0.25f)
                .edge(true)
                .edgeSize(0.18f)
                .velocityThreshold(2400)
                .touchSize(32)
                .build();
        slidr = Slidr.attach(this, slidrConfig);
    }
    @Override
    protected void onResume(){
        super.onResume();
       // price = mMenuDetailActivityViewImp.getNumPicked() * 100;
        //mMenuDetailActivityViewImp.setPriceTextView(Integer.toString(price));
    }
}
