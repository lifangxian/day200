package com.example.www.dazonghe.fragemnt;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;

import com.example.www.dazonghe.BaseFragment;
import com.example.www.dazonghe.R;

public class Fragment_ni extends BaseFragment {

    private Button button;
    private DrawerLayout drawer;

    @Override
    protected int bindlayout() {
        return R.layout.frag_ni;
    }

    @Override
    protected void initView() {
        button = bindView(R.id.button);
        drawer = bindView(R.id.drawer);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void bindEvent() {
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }
}
