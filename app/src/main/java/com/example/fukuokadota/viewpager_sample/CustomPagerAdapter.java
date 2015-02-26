package com.example.fukuokadota.viewpager_sample;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class CustomPagerAdapter extends PagerAdapter{

    ArrayList<Integer> ids = new ArrayList<Integer>();
    Context context;

    public CustomPagerAdapter(Context context){
        this.context = context;
    }

    public void add(int id){
        ids.add(id);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView v = new ImageView(context);

        v.setImageResource(ids.get(position));

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return ids.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
