package com.example.pkmara.activities.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pkmara.R;
import com.example.pkmara.models.MenuObject;

import java.util.ArrayList;
import com.daimajia.swipe.util.Attributes;

public class CartActivityViewImpl implements CartActivityView{

    private View mRootView;
    private TextView tvEmptyTextView;
    private RecyclerView mRecyclerView;
    private Context mContext;
    private AppCompatActivity mAppCompatActivity;
    private ArrayList<MenuObject> mDataSet;
    SwipeRecyclerViewAdapter mAdapter;

    public CartActivityViewImpl(Context context, ViewGroup container,  ArrayList<MenuObject> d){
        mContext = context;
        mAppCompatActivity = (AppCompatActivity)context;
        //Typeface typeface = Typeface.createFromAsset(mAppCompatActivity.getAssets(), "fonts/batb.ttf");
        mRootView = LayoutInflater.from(context).inflate(R.layout.activity_cart_layout, container);
        tvEmptyTextView = (TextView) mRootView.findViewById(R.id.empty_view);
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mAppCompatActivity));
        mDataSet = d;
        Log.e("mDataSet", mDataSet.toString());
        if(mDataSet.isEmpty()){
            mRecyclerView.setVisibility(View.GONE);
            tvEmptyTextView.setVisibility(View.VISIBLE);
        }else{
            mRecyclerView.setVisibility(View.VISIBLE);
            tvEmptyTextView.setVisibility(View.GONE);
        }
        mAdapter = new SwipeRecyclerViewAdapter(mAppCompatActivity, mDataSet);
        ((SwipeRecyclerViewAdapter) mAdapter).setMode(Attributes.Mode.Single);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("RecyclerView", "onScrollStateChanged");
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    public SwipeRecyclerViewAdapter getmAdapter() {
        return mAdapter;
    }
    @Override
    public View getRootView(){
        return mRootView;
    }
    @Override
    public Bundle getViewState(){return null;}
}
