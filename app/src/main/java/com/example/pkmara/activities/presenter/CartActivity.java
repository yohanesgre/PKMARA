package com.example.pkmara.activities.presenter;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.pkmara.activities.view.CartActivityViewImpl;
import com.example.pkmara.models.OrderJSON;

public class CartActivity extends AppCompatActivity{
    CartActivityViewImpl mCartActivityViewImpl;
    OrderJSON mOrderJson;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOrderJson = MainActivity.mOrderJSON;
        mCartActivityViewImpl = new CartActivityViewImpl(this, null, mOrderJson.getArrMenuObj());
        setContentView(mCartActivityViewImpl.getRootView());
    }
}
