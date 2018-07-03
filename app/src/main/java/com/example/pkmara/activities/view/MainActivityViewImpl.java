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

import org.w3c.dom.Text;

public class MainActivityViewImpl implements MainActivityView{

    private View mRootView;
    private EditText etNama;

    private Context mContext;
    private AppCompatActivity mAppCompatActivity;

    public MainActivityViewImpl(Context context, ViewGroup container){
        mContext = context;
        mAppCompatActivity = (AppCompatActivity)context;
        Typeface typeface = Typeface.createFromAsset(mAppCompatActivity.getAssets(), "fonts/batb.ttf");
        mRootView = LayoutInflater.from(context).inflate(R.layout.activity_main_layout, container);
        etNama = (EditText)mRootView.findViewById(R.id.etNamaPelanggan);
        TextView tvYourName = (TextView)mRootView.findViewById(R.id.tvYourName);
        TextView tvSeat = (TextView)mRootView.findViewById(R.id.tvSeat);
        TextView tvNoSeat = (TextView)mRootView.findViewById(R.id.tvNoSeat);
        Button btnOrder = (Button)mRootView.findViewById(R.id.btnOrder);
        tvYourName.setTypeface(typeface);
        tvSeat.setTypeface(typeface);
        btnOrder.setTypeface(typeface);
    }

    @Override
    public View getRootView(){
        return mRootView;
    }
    @Override
    public Bundle getViewState(){return null;}
    @Override
    public String getNama(){
        String nama = etNama.getText().toString();
        return nama;
    }
}
