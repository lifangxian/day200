package com.example.www.dazonghe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(bindlayout(),container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
        bindEvent();
    }

    protected abstract int bindlayout();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void bindEvent();
    protected <T extends View> T bindView(int resid){
        return (T)getView().findViewById(resid);
    }
}
