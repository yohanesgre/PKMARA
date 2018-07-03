package com.example.pkmara.activities.view;

import android.content.Context;
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
import com.shawnlin.numberpicker.NumberPicker;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pkmara.R;

import java.util.Locale;

public class MenuDetailActivityViewImpl implements MenuDetailActivityView {
    private View mRootView;
    private TextView tvMenuName;
    private TextView tvMenuDesc;
    private EditText tvPrice;
    private Context mContext;
    private ActionBar mActionBar;
    private AppCompatActivity mAppCompatActivity;
    private NumberPicker mNumberPicker;
    final String TAG = "Debug";
    public int numPicked = 0;

    public MenuDetailActivityViewImpl(Context context, ViewGroup container, String n){
        mContext = context;
        mAppCompatActivity = (AppCompatActivity)context;
        mRootView = LayoutInflater.from(context).inflate(R.layout.activity_menudetail_layout, container);
        // Initialize Handler.
        tvMenuName = (TextView)mRootView.findViewById(R.id.tvMenuName);
        tvMenuName.setText(n);
        tvMenuDesc = (TextView)mRootView.findViewById(R.id.tvMenuDesc);
        tvPrice = (EditText)mRootView.findViewById(R.id.tvMenuPrice);
        tvPrice.setInputType(InputType.TYPE_NULL);
        mNumberPicker =  (NumberPicker)mRootView.findViewById(R.id.horizontal_number_picker);
        mNumberPicker.setMinValue(0);
        mNumberPicker.setMaxValue(10);
        mNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d(TAG, String.format(Locale.US, "oldVal: %d, newVal: %d", oldVal, newVal));
                numPicked = newVal;
                tvPrice.setText(newVal);
            }
        });
        mActionBar = mAppCompatActivity.getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public View getRootView(){
        return mRootView;
    }
    @Override
    public Bundle getViewState(){return null;}
}
