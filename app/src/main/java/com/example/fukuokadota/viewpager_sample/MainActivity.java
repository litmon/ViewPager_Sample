package com.example.fukuokadota.viewpager_sample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.viewpagerindicator.PageIndicator;


public class MainActivity extends ActionBarActivity {

    ViewPager pager;
    CustomPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.view2);

        adapter = new CustomPagerAdapter(this);

        adapter.add(R.drawable.c1);
        adapter.add(R.drawable.c2);
        adapter.add(R.drawable.c3);
        adapter.add(R.drawable.c4);
        adapter.add(R.drawable.c5);

        pager.setAdapter(adapter);

        PageIndicator indicator = (PageIndicator) findViewById(R.id.view);
        indicator.setViewPager(pager);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem() - 1);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem() + 1);
            }
        });

        // ViewPager.OnPageChangeListenerを入れるとindicatorがどうなるか検証
        ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("OnPageChangeListener", "onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("OnPageChangeListener", "onPageSelected");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("OnPageChangeListener", "onPageScrollStateChanged");
            }
        };

        // => indicatorが無効になった(onPageChangeListenerが上書きされたせい)
        // これがセットされてるとindicator.setOn~~を呼んでも反応しなくなるっぽい
        // pager.setOnPageChangeListener(listener);

        // listener追加する要素があったみたい
        indicator.setOnPageChangeListener(listener);
    }
}
