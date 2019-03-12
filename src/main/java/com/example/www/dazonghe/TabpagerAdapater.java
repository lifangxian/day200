package com.example.www.dazonghe;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabpagerAdapater extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayList;
    private ArrayList<String> listt;

    public TabpagerAdapater(FragmentManager fm, ArrayList<Fragment> arrayList, ArrayList<String> listt) {
        super(fm);
        this.arrayList = arrayList;
        this.listt = listt;
    }

    @Override
    public Fragment getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listt.get(position);
    }
}
