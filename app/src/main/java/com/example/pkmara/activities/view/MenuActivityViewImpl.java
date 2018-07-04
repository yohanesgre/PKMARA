package com.example.pkmara.activities.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pkmara.R;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.r0adkll.slidr.model.SlidrPosition;
import com.roughike.swipeselector.SwipeItem;
import com.roughike.swipeselector.SwipeSelector;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class MenuActivityViewImpl implements MenuActivityView{

    private View mRootView;
    private ViewPager mViewPager;
    private Context mContext;
    private NavigationTabBar mNTB;
    private ActionBar mActionBar;
    private AppCompatActivity mAppCompatActivity;
    private TextView mNamaPelanggan;
    private SwipeItem swipeItem;
    private SwipeSelector mSwipeSelector;
    private SwipeSelector category1;
    private SwipeSelector category2;
    private int currentPage;

    public MenuActivityViewImpl(Context context, ViewGroup container, String n){
        mContext = context;
        mAppCompatActivity = (AppCompatActivity)context;
        mRootView = LayoutInflater.from(context).inflate(R.layout.activity_menu_layout, container);
        mViewPager = (ViewPager) mRootView.findViewById(R.id.vp_horizontal_ntb);
        mNTB = (NavigationTabBar) mRootView.findViewById(R.id.ntb_horizontal);
        mNamaPelanggan = (TextView) mRootView.findViewById(R.id.tvNamaPelanggan);
        mNamaPelanggan.setText(n);
        mViewPager.setAdapter(new ViewPageAdapter());
        initUI();
        mActionBar = mAppCompatActivity.getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public View getRootView(){
        return mRootView;
    }
    @Override
    public Bundle getViewState(){return null;}
    @Override
    public ViewPager getViewPager(){return mViewPager;}
    @Override
    public NavigationTabBar getNTB() {return mNTB;}
    private void initUI() {
        final String[] colors = mContext.getResources().getStringArray(R.array.default_preview);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        mContext.getResources().getDrawable(R.drawable.ic_first),
                        Color.parseColor(colors[0]))
                        .selectedIcon(mContext.getResources().getDrawable(R.drawable.ic_sixth))
                        .title("Heart")
                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        mContext.getResources().getDrawable(R.drawable.ic_second),
                        Color.parseColor(colors[1]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("Cup")
                        .badgeTitle("with")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        mContext.getResources().getDrawable(R.drawable.ic_third),
                        Color.parseColor(colors[2]))
                        .selectedIcon(mContext.getResources().getDrawable(R.drawable.ic_seventh))
                        .title("Diploma")
                        .badgeTitle("state")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        mContext.getResources().getDrawable(R.drawable.ic_fourth),
                        Color.parseColor(colors[3]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("Flag")
                        .badgeTitle("icon")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        mContext.getResources().getDrawable(R.drawable.ic_fifth),
                        Color.parseColor(colors[4]))
                        .selectedIcon(mContext.getResources().getDrawable(R.drawable.ic_eighth))
                        .title("Medal")
                        .badgeTitle("777")
                        .build()
        );

        mNTB.setModels(models);
        mNTB.setViewPager( mViewPager, 0);
        mNTB.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                mNTB.getModels().get(position).hideBadge();
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        mNTB.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < mNTB.getModels().size(); i++) {
                    final NavigationTabBar.Model model = mNTB.getModels().get(i);
                    mNTB.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            model.showBadge();
                        }
                    }, i * 100);
                }
            }
        }, 500);
    }

    private class ViewPageAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(final View view, final Object object) {
            return view.equals(object);
        }

        @Override
        public void destroyItem(final View container, final int position, final Object object) {
            ((ViewPager) container).removeView((View) object);
        }

        @Override
        public Object instantiateItem(final ViewGroup container, final int position) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_vp, null, false);
            switch (position){
                case 0:
                {
                    category1 = (SwipeSelector) view.findViewById(R.id.menuSelector);
                    category1.setItems(
                            new SwipeItem(1, "MenuName 1", "100"),
                            new SwipeItem(2, "MenuName 2", "200"),
                            new SwipeItem(3, "MenuName 3", "300")
                    );
                    break;
                }
                case 1:
                {
                    category2 = (SwipeSelector) view.findViewById(R.id.menuSelector);
                    category2.setItems(
                            new SwipeItem(3, "MenuName 4", "100"),
                            new SwipeItem(4, "MenuName 5", "200"),
                            new SwipeItem(5, "MenuName 6", "300")
                    );
                    break;
                }
                default:
                    break;
            }
            container.addView(view);
            return view;
        }
    }

    @Override
    public SwipeItem getSwipeItem() {
        switch (currentPage) {
            case 0:
                swipeItem = category1.getSelectedItem();
                break;
            case 1:
                swipeItem = category2.getSelectedItem();
                break;
        }
        return swipeItem;
    }
}
