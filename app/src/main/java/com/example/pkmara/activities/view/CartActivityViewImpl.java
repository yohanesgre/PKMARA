package com.example.pkmara.activities.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pkmara.R;

public class CartActivityViewImpl implements CartActivityView{

    private View mRootView;
    private Context mContext;
    private AppCompatActivity mAppCompatActivity;



    public CartActivityViewImpl(Context context, ViewGroup container){
        mContext = context;
        mAppCompatActivity = (AppCompatActivity)context;
        //Typeface typeface = Typeface.createFromAsset(mAppCompatActivity.getAssets(), "fonts/batb.ttf");
        mRootView = LayoutInflater.from(context).inflate(R.layout.activity_main_layout, container);
    }

    @Override
    public View getRootView(){
        return mRootView;
    }
    @Override
    public Bundle getViewState(){return null;}
}
