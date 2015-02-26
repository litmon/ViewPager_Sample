package com.example.fukuokadota.viewpager_sample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.viewpagerindicator.PageIndicator;


public class MainActivity extends ActionBarActivity {

    ViewPager pager;
    CustomPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.view2);
        PageIndicator indicator = (PageIndicator) findViewById(R.id.view);


        adapter = new CustomPagerAdapter(this);

        adapter.add(R.drawable.c1);
        adapter.add(R.drawable.c2);
        adapter.add(R.drawable.c3);
        adapter.add(R.drawable.c4);
        adapter.add(R.drawable.c5);

        pager.setAdapter(adapter);
        indicator.setViewPager(pager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
