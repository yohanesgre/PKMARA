package com.example.pkmara.activities.view;

import android.support.v4.view.ViewPager;

import com.example.pkmara.viewmvp.ViewMvp;
import com.roughike.swipeselector.SwipeItem;

import devlight.io.library.ntb.NavigationTabBar;

public interface MenuActivityView extends ViewMvp {
    ViewPager getViewPager();
    NavigationTabBar getNTB();
    SwipeItem getSwipeItem();
}
