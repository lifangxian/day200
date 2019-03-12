package com.example.www.dazonghe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindlayout());
        initView();
        initData();
        bindEvent();

    }

    public abstract int bindlayout();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void bindEvent();

    protected <T extends View> T bindView(int resid){
        return (T)findViewById(resid);
    }
}
