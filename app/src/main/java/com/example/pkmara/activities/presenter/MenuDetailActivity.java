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
    int menuQuantity;
    OrderJSON mOrderJSON;
    MenuObject menuObject;
    final String TAG = "Debug";

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mOrderJSON = MainActivity.mOrderJSON;
        menuName = getIntent().getStringExtra("MENU_NAME");
        if (mOrderJSON.getArrMenuObj().isEmpty()){
            menuQuantity = getIntent().getIntExtra("MENU_QUANTITY", 0);
            menuPrice = getIntent().getStringExtra("MENU_PRICE");
        }else if (mOrderJSON.getArrMenuObj().get(mOrderJSON.findIndexMenuObjectByName(menuName)).getMenuName().equals(menuName)){
            menuQuantity = mOrderJSON.getArrMenuObj().get(mOrderJSON.findIndexMenuObjectByName(menuName)).getQuantitiy();
            menuPrice = String.valueOf(mOrderJSON.getArrMenuObj().get(mOrderJSON.findIndexMenuObjectByName(menuName)).getPrice());
        } else {
            menuQuantity = getIntent().getIntExtra("MENU_QUANTITY", 0);
            menuPrice = getIntent().getStringExtra("MENU_PRICE");
        }
        Log.d(TAG, "Nama Menu: " + menuName + " | " + "Price: " + menuPrice + "| Quantity: " + menuQuantity);
        mMenuDetailActivityViewImp = new MenuDetailActivityViewImpl(this, null, menuName, menuPrice, menuQuantity);
        setContentView(mMenuDetailActivityViewImp.getRootView());
    }

    public void buyMenu(View v){
        menuObject = new MenuObject(menuName, mMenuDetailActivityViewImp.getMenuQuantity(), mMenuDetailActivityViewImp.getMenuPriceTot());
        Log.d(TAG, "BuyMenuNama Menu: " + menuObject.getMenuName() + "   " + menuName + " | " + "Quantity: " + menuObject.getQuantitiy() + "Price: " + mMenuDetailActivityViewImp.getMenuPriceTot() +"| Index: " + mOrderJSON.findIndexMenuObjectByName(menuObject.getMenuName()));

        if (mOrderJSON.getArrMenuObj().isEmpty()){
            mOrderJSON.addMenuObj(menuObject);
            Log.d(TAG, "Nama Menu: " + menuObject.getMenuName() + " | " + "Quantity: " + menuObject.getQuantitiy() + "Price: " + mMenuDetailActivityViewImp.getMenuPriceTot() +"| Index: " + mOrderJSON.findIndexMenuObjectByName(menuObject.getMenuName()));
        }
        else if(mOrderJSON.getArrMenuObj().get(mOrderJSON.findIndexMenuObjectByName(menuName)).getMenuName().equals(menuObject.getMenuName())){
            Log.d(TAG, "1Nama Menu: " + menuObject.getMenuName() + " | " + "Quantity: " + menuObject.getQuantitiy() + "| Index: " + mOrderJSON.findIndexMenuObjectByName(menuObject.getMenuName()));
            mOrderJSON.updateMenuObjByObject(menuObject);
        } else {
            mOrderJSON.addMenuObj(menuObject);
            Log.d(TAG, "2Nama Menu: " + menuObject.getMenuName() + " | " + "Quantity: " + menuObject.getQuantitiy() + "| Index: " + mOrderJSON.findIndexMenuObjectByName(menuObject.getMenuName()));
        }
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}
