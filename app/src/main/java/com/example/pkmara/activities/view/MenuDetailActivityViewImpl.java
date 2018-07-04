package com.example.pkmara.activities.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.r0adkll.slidr.model.SlidrPosition;
import com.shawnlin.numberpicker.NumberPicker;
import android.widget.TextView;
import com.example.pkmara.R;

public class MenuDetailActivityViewImpl implements MenuDetailActivityView {
    private View mRootView;
    private int menuQuantity = 0;
    private int menuPrice = 0;
    private int menuPriceTot = 0;
    private TextView tvMenuName;
    private TextView tvMenuDesc;
    private TextView tvPrice;
    private Context mContext;
    private ActionBar mActionBar;
    private AppCompatActivity mAppCompatActivity;
    private NumberPicker mNumberPicker;
    private SlidrInterface slidr;
    private SlidrConfig slidrConfig;
    final String TAG = "Debug";


    public MenuDetailActivityViewImpl(Context context, ViewGroup container, String n, String p, int q){
        mContext = context;
        mAppCompatActivity = (AppCompatActivity)context;
        mRootView = LayoutInflater.from(context).inflate(R.layout.activity_menudetail_layout, container);
        tvMenuName = (TextView)mRootView.findViewById(R.id.tvMenuName);
        tvMenuName.setText(n);
        tvMenuDesc = (TextView)mRootView.findViewById(R.id.tvMenuDesc);
        tvPrice = (TextView) mRootView.findViewById(R.id.tvMenuPrice);
        tvPrice.setInputType(InputType.TYPE_NULL);
        mNumberPicker =  (NumberPicker)mRootView.findViewById(R.id.horizontal_number_picker);
        mNumberPicker.setValue(q);
        mNumberPicker.setMinValue(0);
        mNumberPicker.setMaxValue(10);
        Log.d("Q", "Q: " + String.valueOf(q));
        if (q == 0){
            tvPrice.setText("Rp. ");
            menuPrice = Integer.parseInt(p);
            Log.d("Q", "Q: 000");
        }
        else if (q == 1){
            Log.d("Q", "Q: " + String.valueOf(q));
            menuPrice = Integer.parseInt(p);
            tvPrice.setText("Rp. " + String.valueOf(menuPrice));

        } else if (q > 1){
            Log.d("Q", "Q: " + String.valueOf(q));
            menuPrice = Integer.parseInt(p);
            menuPriceTot = menuPrice;
            menuPrice = Integer.parseInt(p)/q;
            tvPrice.setText("Rp. " + String.valueOf(menuPriceTot));

        }
        mNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                //Log.d(TAG, String.format(Locale.US, "oldVal: %d, newVal: %d", oldVal, newVal));
                menuPriceTot = newVal * menuPrice;
                menuQuantity = newVal;
                tvPrice.setText("Rp. " + String.valueOf(menuPriceTot));
            }
        });
        mActionBar = mAppCompatActivity.getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        int primaryColor = mAppCompatActivity.getResources().getColor(R.color.primaryDark);
        int secondaryColor = mAppCompatActivity.getResources().getColor(R.color.colorAccent);
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
        slidr = Slidr.attach(mAppCompatActivity, slidrConfig);
    }

    public int getMenuPriceTot() {
        return menuPriceTot;
    }

    public int getMenuQuantity() {
        return menuQuantity;
    }

    @Override
    public View getRootView(){
        return mRootView;
    }
    @Override
    public Bundle getViewState(){return null;}
}
