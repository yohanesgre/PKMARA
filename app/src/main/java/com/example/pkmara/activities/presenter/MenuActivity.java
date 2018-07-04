package com.example.pkmara.activities.presenter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pkmara.R;
import com.example.pkmara.activities.view.MenuActivityViewImpl;
import com.example.pkmara.models.MenuObject;
import com.example.pkmara.models.OrderJSON;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;
import com.roughike.swipeselector.SwipeItem;
import com.roughike.swipeselector.SwipeSelector;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class MenuActivity extends AppCompatActivity {
    MenuActivityViewImpl mMenuActivityImpl;
    ViewPager mViewPager;
    OrderJSON mOrderJSON;
    String name;
    final String TAG = "Debug";
    Button btnBuy;
    Button btnCart;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mOrderJSON = MainActivity.mOrderJSON;
        name = mOrderJSON.getName();
        mMenuActivityImpl = new MenuActivityViewImpl(this, null, name);
        setContentView(mMenuActivityImpl.getRootView());
        mViewPager = mMenuActivityImpl.getViewPager();
        btnBuy = (Button)mMenuActivityImpl.getRootView().findViewById(R.id.btBuy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectMenu();
            }
        });
        btnCart = (Button)mMenuActivityImpl.getRootView().findViewById(R.id.btCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartMenu();
            }
        });

    }

    public void selectMenu(){
        Intent intent = new Intent(this, MenuDetailActivity.class);
        if (mOrderJSON.getArrMenuObj().isEmpty()){
            intent.putExtra("MENU_NAME", mMenuActivityImpl.getSwipeItem().title);
            intent.putExtra("MENU_PRICE", mMenuActivityImpl.getSwipeItem().description);
        }else {
            if (mOrderJSON.getArrMenuObj().get(mOrderJSON.findIndexMenuObjectByName(mMenuActivityImpl.getSwipeItem().title)).getMenuName().equals(mMenuActivityImpl.getSwipeItem().title)) {
                intent.putExtra("MENU_NAME", mMenuActivityImpl.getSwipeItem().title);
                intent.putExtra("MENU_PRICE", String.valueOf(mOrderJSON.getArrMenuObj().get(mOrderJSON.findIndexMenuObjectByName(mMenuActivityImpl.getSwipeItem().title)).getPrice()));
                Log.d("DEBUG", String.valueOf(mOrderJSON.getArrMenuObj().get(mOrderJSON.findIndexMenuObjectByName(mMenuActivityImpl.getSwipeItem().title)).getPrice()));
                intent.putExtra("MENU_QUANTITY", mOrderJSON.getArrMenuObj().get(mOrderJSON.findIndexMenuObjectByName(mMenuActivityImpl.getSwipeItem().title)).getQuantitiy());
            } else {
                intent.putExtra("MENU_NAME", mMenuActivityImpl.getSwipeItem().title);
                intent.putExtra("MENU_PRICE", mMenuActivityImpl.getSwipeItem().description);
            }
        }

        startActivity(intent);
        //String qtyStr = mMenuActivityImpl.getSwipeItem().description;
        //int qtyInt = Integer.parseInt(qtyStr);
        //menuObject = new MenuObject();
        //menuObject.setMenuName(mMenuActivityImpl.getSwipeItem().title);
        //menuObject.setQuantitiy(qtyInt);
        //Log.d(TAG, "Nama Menu: " + menuObject.getMenuName() + " | " + "Quantity: " + menuObject.getQuantitiy());
        //mOrderJSON.addMenuObj(menuObject);
    }

    public void cartMenu(){
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }
}
