package com.example.pkmara.activities.presenter;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.pkmara.activities.view.CartActivityViewImpl;

public class CartActivity extends AppCompatActivity{
    CartActivityViewImpl mCartActivityViewImpl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mCartActivityViewImpl = new CartActivityViewImpl(this, null);
        setContentView(mCartActivityViewImpl.getRootView());
    }
}
