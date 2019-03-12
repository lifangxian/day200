package com.example.www.dazonghe.fragemnt;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.www.dazonghe.BaseFragment;
import com.example.www.dazonghe.R;
import com.example.www.dazonghe.TabpagerAdapater;
import com.example.www.dazonghe.TwoActivity;
import com.example.www.dazonghe.tab.Tab1;
import com.example.www.dazonghe.tab.Tab2;

import java.util.ArrayList;

public class Fragment_shou extends BaseFragment {

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> arrayList;
    private ArrayList<String> listt;
    private TabpagerAdapater tabpagerAdapater;
    private ImageView imageView;

    @Override
    protected int bindlayout() {
        return R.layout.frag_shou;
    }

    @Override
    protected void initView() {
        vp = bindView(R.id.viewpager);
        tab = bindView(R.id.tab);
        imageView = bindView(R.id.imageview);
    }

    @Override
    protected void initData() {
        //先是viewpager的数据
        arrayList = new ArrayList<>();
        arrayList.add(new Tab1());
        arrayList.add(new Tab2());
        //tab数据
        listt = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            listt.add("孙悟空"+i);
        }
        tabpagerAdapater = new TabpagerAdapater(getActivity().getSupportFragmentManager(),arrayList,listt);
        vp.setAdapter(tabpagerAdapater);
        //关联
        tab.setupWithViewPager(vp);
    }

    @Override
    protected void bindEvent() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),TwoActivity.class);
                intent.putStringArrayListExtra("key",listt);
                startActivityForResult(intent,200);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200){
            ArrayList<String> list = data.getStringArrayListExtra("key");
            //清除所有页面的数据
            arrayList.clear();
            listt.clear();
            //把tab数据清空
            tab.removeAllTabs();
            //合并集合
            listt.addAll(list);
            for (int t=0;t<listt.size();t++){
                //创建一个集合
                TabLayout.Tab tabb = this.tab.newTab();
                //给tab设置一个标题
                tabb.setText(listt.get(t));
                //把新的tab放到tablayout里
                tab.addTab(tabb);
                //重新装填fragment
                String s = listt.get(t);
                if(t==0){
                    arrayList.add(new Tab1());
                }else{
                    arrayList.add(new Tab2());
                }
            }
            tabpagerAdapater.notifyDataSetChanged();
            tab.setupWithViewPager(vp);
        }
    }
}
