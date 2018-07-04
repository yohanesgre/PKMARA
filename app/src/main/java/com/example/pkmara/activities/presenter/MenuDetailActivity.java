package com.example.pkmara.activities.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.pkmara.activities.view.MenuDetailActivityViewImpl;
import com.example.pkmara.models.MenuObject;
import com.example.pkmara.models.OrderJSON;


public class MenuDetailActivity extends AppCompatActivity {
    MenuDetailActivityViewImpl mMenuDetailActivityViewImp;
    String menuName;
    String menuPrice;
    OrderJSON mOrderJSON;
    MenuObject menuObject;
    final String TAG = "Debug";

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mOrderJSON = MainActivity.mOrderJSON;
        menuName = getIntent().getStringExtra("MENU_NAME");
        menuPrice = getIntent().getStringExtra("MENU_PRICE");
        mMenuDetailActivityViewImp = new MenuDetailActivityViewImpl(this, null, menuName, menuPrice);
        setContentView(mMenuDetailActivityViewImp.getRootView());
    }

    public void buyMenu(View v){
        menuObject = new MenuObject(menuName, mMenuDetailActivityViewImp.getMenuQuantity(),mMenuDetailActivityViewImp.getMenuPriceTot());
        if (mOrderJSON.getArrMenuObj().isEmpty()){
            mOrderJSON.addMenuObj(menuObject);
            Log.d(TAG, "Nama Menu: " + menuObject.getMenuName() + " | " + "Quantity: " + menuObject.getQuantitiy());
        }
        else if(menuObject.getMenuName() == mOrderJSON.getMenuByName(menuName).getMenuName()){
            mOrderJSON.updateMenuObjByObject(menuObject);
        } else {
            mOrderJSON.addMenuObj(menuObject);
        }
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}
